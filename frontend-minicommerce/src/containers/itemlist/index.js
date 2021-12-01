import React, { Component } from "react";
import Item from "../../components/Item";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig.js";
import Button from "../../button";
import Modal from "../../modal";
import {Badge, Fab} from "@material-ui/core";
import ViewStreamIcon from '@mui/icons-material/ViewStream';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';


class ItemList extends Component {
   constructor(props) {
   super(props);
  this.state = {
  cartItems: [],
  cartHidden: true,
  items: [],
  isLoading: false,
  isCreate: false,
  isEdit: false,
  id: "",
  title: "",
  price: 0,
  description: "",
  category: "",
  quantity: 0
 };
   this.handleClickLoading = this.handleClickLoading.bind(this);
   this.handleAddItem = this.handleAddItem.bind(this);
   this.handleCancel = this.handleCancel.bind(this);
   this.handleChangeField = this.handleChangeField.bind(this);
   this.handleSubmitItem = this.handleSubmitItem.bind(this);
   this.handleEditItem = this.handleEditItem.bind(this);
   this.handleSubmitEditItem = this.handleSubmitEditItem.bind(this);
   this.search = this.search.bind(this);
}

componentDidMount() {
   this.loadData();
}


async search(event) {
    event.preventDefault();
    console.log(event.target.value);
    try {
        const { data } = await APIConfig.get(`/item?title=${event.target.value}`);
        this.setState({ items: data.result });
        // console.log(event.target.value);
    } catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
    }
    this.handleCancel(event);
}

async loadData() {
    try {
        const { data } = await APIConfig.get("/item");
        this.setState({ items: data.result });
    } catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
    }
}

async handleSubmitItem(event) {
    event.preventDefault();
    try {
        const data = {
        title: this.state.title,
        price: this.state.price,
        description: this.state.description,
        category: this.state.category, quantity:
        this.state.quantity
        };
        await APIConfig.post("/item", data);
        this.setState({
        title: "",
        price: 0,
        description: "",
        category: "",
        quantity: 0
    })
        this.loadData();
    } catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
        }
        this.handleCancel(event);
}

async handleSubmitEditItem(event) { 
    event.preventDefault();
    try {
    const data = {
    title: this.state.title,
    price: this.state.price, 
    description: this.state.description, 
    category: this.state.category, 
    quantity: this.state.quantity
  };
  await APIConfig.put(`/item/${this.state.id}`, data); 
  this.setState({
    id: "",
    title: "",
    price: 0, 
    description: "", 
    category: "", 
    quantity: 0
  })
  this.loadData(); 
} catch (error) {
    alert("Oops terjadi masalah pada server");
    console.log(error); }
    this.handleCancel(event); 
}

handleAddItem() {
    this.setState({ isCreate:true });
}

handleCancel(event) {
    event.preventDefault();
    this.setState({ isCreate:false, isEdit: false });
}

handleChangeField(event) {
    const { name, value } = event.target;
    this.setState({ [name]: value });
}

handleEditItem(item) { 
    this.setState({ 
        isEdit: true,
        id: item.id,
        title: item.title,
        price: item.price, 
        description: item.description, 
        category: item.category, 
        quantity: item.quantity
   }) 
}

handleToggle = () => {
    const cartHidden = this.state.cartHidden;
    this.setState({cartHidden: !cartHidden });
}


// handleAddItemToCart() {
//     this.setState({cartHidden : false});
// }

handleSubmitItemToCart(item) {
    const newItems = [...this.state.cartItems];
    const newItem = {...item};
    const targetInd = newItems.findIndex((it) => it.id === newItem.id);
    // let newBalance = this.state.balance;
    if (targetInd < 0) {
        // if (newBalance < newItem.price) {
        //     alert("Balance not sufficent!");
        //     return;
        // }
        newItem.inCart = true;
        newItems.push(newItem);
        this.updateShopItem(newItem, true);
        // newBalance = newBalance - newItem.price;
    } 
    // this.setState({balance: newBalance});
    this.setState({cartItems: newItems });
}

updateShopItem = (item, inCart) => {
    const tempShopItems = this.state.items;
    const targetInd = tempShopItems.findIndex((it) => it.id === item.id);
    tempShopItems [targetInd].inCart = inCart;
    this.setState({shopItems: tempShopItems });
}

//shouldComponentUpdate(nextProps, nextState) {
//   console.log("shouldComponentUpdate()");
//}
//

handleClickLoading() {
   const currentLoading = this.state.isLoading;
   this.setState({ isLoading: !currentLoading });
   console.log(this.state.isLoading);
}

  render() {
    return (
    
    <div className={classes.itemList}>

        <div style={{position: "fixed", top: 25, right: 25}}>
            <Fab variant="extended" onClick={this.handleToggle}>
                {this.state.cartHidden ?
                    <Badge color="secondary" badgeContent={this.state.cartItems.length}>
                        <ShoppingCartIcon />
                    </Badge>
                    : <ViewStreamIcon/>}
            </Fab>
        </div>

        {this.state.cartHidden ? (
            <div className={classes.itemList}>
                <input className={classes.textField} 
                type="text" 
                placeholder="Cari Item Berdasarkan Nama Item" 
                name="search"
                onChange={this.search}/>

                <h1 className={classes.title}>
                    All Items</h1>
                <Button action={this.handleAddItem}>
                    Add Item
                </Button>

                <div>
                {this.state.items.map((item) => (
                <Item
                key={item.id}
                id={item.id}
                title={item.title}
                price={item.price}
                description={item.description}
                category={item.category}
                quantity={item.quantity}
                handleEdit={() => this.handleEditItem(item)} 
                handleAddToCart={() => this.handleSubmitItemToCart(item)}/>
                ))}
                </div>

                <Modal
                    show={this.state.isCreate || this.state.isEdit}
                    handleCloseModal={this.handleCancel}
                    modalTitle={this.state.isCreate
                    ? "Add Item"
                    : `Edit Item ID ${this.state.id}`} >
                    <form>
                    <input className={classes.textField} type="text" placeholder="Nama Item" name="title"
                    value={this.state.title} onChange={this.handleChangeField}/>

                    <input className={classes.textField} type="number" placeholder="Harga" name="price"
                    value={this.state.price} onChange={this.handleChangeField}/>

                    <textarea className={classes.textField} placeholder="Deskripsi" name="description"rows="4"
                    value={this.state.description} onChange={this.handleChangeField}/>

                    <input className={classes.textField} type="text" placeholder="Kategori" name="category"
                    value={this.state.category} onChange={this.handleChangeField}/>

                    <input className={classes.textField} type="number" placeholder="qty" name="quantity"
                    value={this.state.quantity} onChange={this.handleChangeField}/>

                        <Button action={this.state.isCreate ? this.handleSubmitItem : this.handleSubmitEditItem} >
                            Create
                        </Button>
                        <Button action={this.handleCancel}>
                            Cancel
                        </Button>
                    </form>
                </Modal>
                
            </div>
        ) :
            <div className="col-sm">
                <Item title="My Cart"
                    items={this.state.cartItems}
                    onItemClick={this.handleDeleteItemFromCart}>
                </Item>
            </div>
        }
            


    </div>
  );
 }
}

export default ItemList;