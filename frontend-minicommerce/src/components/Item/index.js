import React from "react";
import Button from "../../button";
import classes from "./styles.module.css";
import AddShoppingCartIcon from '@mui/icons-material/AddShoppingCart';
import {IconButton} from "@material-ui/core";


const Item = (props) => {
 const { id, title, price, description, category, quantity, handleEdit, handleDelete, handleAddToCart, handleQuantity} = props;
  return (
   <div className={classes.item}>
     <h3>{`ID ${id}`}</h3>
     <p>{`Nama Barang: ${title}`}</p>
     <p>{`Harga: ${price}`}</p>
     <p>{`Deskripsi: ${description}`}</p>
     <p>{`Kategori: ${category}`}</p>
     <p>{`stok: ${quantity}`}</p>
     <Button action={handleEdit}>
        Edit
     </Button>
     <Button action={handleAddToCart}>
        Add to Cart
     </Button>
     <div>
     <input
         action={handleQuantity}
      />
      </div>
   </div>
 );
};

export default Item;