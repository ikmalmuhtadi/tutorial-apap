# Tutorial APAP
## Authors
* **Ikmal Almuhtadi Rajab** - *1906308324* - *APAP - A*

## Tutorial 5
### What I have learned today
Pada tutorial kali ini saya telah belajar mengenai perbedaan web service dengan Rest API. Selain itu, saya juga belajar mengenai penggunaan dan pemanggilan API di spring menggunakan Postman.

1. Apa itu Postman? Apa kegunaannya? 
 —> Postman adalah sebuah appliaction programing interface (API) development tool yang akan memudahkan user untuk melakukan pengetestan web services. Antara lain di Postman kita dapat membuat, menguji, membagikan, mendokumentasikan, dan memodifikasi API. 
2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty. 
 —> @JsonIgnoreProperties digunakan pada level class untuk memberi tanda sebuah properti untuk dihiraukan. Anotasi ini digunakan utk urusan serialisasi properti atau mengabaikan pemrosesan dalam membaca properti JSON ke objek Java atau yang bisa disebut deserialisasi JSON. Sedangkan ketika kita mendapatkan data JSON dari objek Java, hal tersebut disebut serialisasi JSON. @JsonProperty akan dapat mengubah visibilitas properti menggunakan elemen aksesnya dalam proses serialisasi dan deserialisasi JSON. 
3. Apa kegunaan atribut WebClient? 
 —> WebClient merupakan sebuah interface yang akan berguna sebagai access point utama dari HTTP requests, selain itu WebClient akan berfungsi sebagai pengatur dalam proses request dan response suatu URL. 
4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya? 
 —> ResponseEntity akan berguna untuk mewakili seluruh respons HTTP dan juga akan mengkonfigurasi response HTTP secara keseluruhan. Sedangkan BindingResult biasanya berisi informasi tentang kesalahan, misalkan field yang diperlukan atau adanya ketidakcocokan jenis atau kesalahan ketika memanggil suatu method.
 
--- 

## Tutorial 4
### What I have learned today
Untuk tutorial kali ini saya telah belajar pemanfaat fragment untuk bisa menyesuaikan hal seperti navbar pada setiap halaman. Lalu saya juga belajar untuk bisa menghandle if else pada file HTML secara lebih mendalam. Lab ini cukup membuat saya bingung karena sering sekali terjadi kesalahan routing pada file HTML yang saya buat hehe.

1. Jelaskan perbedaan th:include dan th:replace!
→  th:include dan th:replace merupakan dua dari banyak jenis atribut yang disediakan oleh Thymeleaf yang dapat kita gunakan. Kedua hal tersebut memiliki hubungan dengan fragment. Dimana fragment sendiri adalah sebagian potongan kode yang bisa kita reuse di banyak halaman, contohnya adalah untuk bagian navbar dan footer. Perbedaan antara th:include dan th:replace adalah jika th:include akan memasukkan fragment yang telah ditentukan sebagai body pada tag hostnya, namun tag fragment nya tidak ikut dimasukkan. Sedangkan untuk th:replace, atribut ini akan menghapus kemudian menggantikan tag host, lalu akan menambahkan fragment yang ditentukan.

2. Jelaskan apa fungsi dari th:object!
→ Atribut th:object akan berfungsi untuk menangani pada bagian form input dari user yang selanjutnya digunakan untuk menentukan objek model yang akan digunakan untuk mengumpulkan data dari form.

3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
→ Kedua simbol tersebut merupakan sebuah variable expression, dimana perbedaanya adalah untuk simbol * akan mengevaluasi ekspresi hanya pada objek yang dipilih bukan dari keseluruhan variable maps. Lalu untuk simbol $ akan mengevaluasi ekspresi terhadap keseluruhan variable maps. Apabila terdapat kondisi dimana tidak ada objek yang dipilih, maka untuk kedua simbol ini akan melakukan hal yang sama.

---
## Tutorial 3
### What I have learned today
Pada lab minggu ini saya belajar mengenai pengkoneksian dengan database MySQL dan juga penggunaan JPA repository. Saya mengalami cukup kesulitan pada lab ini karena kompleksitas program sudah semakin bertambah dan banyaknya passing antar MVC yang ada, dimana hal tersebut saya belum sepenuhnya paham karena saat pengerjaan sering terjadi error.

1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model berikut:
@AllArgsConstructor → akan digunakan untuk men-generate constructor dengan satu parameter untuk setiap field di class yang tersebut
@NoArgsConstructor → akan digunakan untuk men-generate constructor tanpa parameter
@Setter → akan men-generate default method setter secara otomatis
@Getter → akan men-generate default method getter secara otomatis
@Entity → akan mendefine nama yang akan dipakai untuk entity
@Table → akan mendefine nama table yang digunakan di database

2. Pada class CabangDB, terdapat method findByNoCabang, apakah kegunaan dari method tersebut?
→ Method tersebut berfungsi untuk mencari cabang berdasarkan nomor cabangnya, dimana nomor cabangnya merupakan parameternya. Method ini kita gunakan salah satunya ketika mendefine suatu CabangModel.

3. Jelaskan perbedaan kegunaan dari anotasi :
@JoinTable → akan digunakan ketika ingin membuat sebuah table baru dan table tersebut memiliki relasi dengan table lainnya, bisa untuk relasi many to many seperti yang dilakukan pada lab saat ini.
@JoinColumn → akan digunakan untuk mendefine composite foreign keys. Anotasi ini akan mengelompokkan anotasi JoinColumn lainnya yang memiliki hubungan yang sama.

4. Pada class PegawaiModel, digunakan anotasi @JoinColumn pada atribut cabang, apa kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa perbedaan nullable dan penggunaan anotasi @NotNull
→ name merupakan nama kolom yang menjadi foreign key untuk PegawaiModel, lalu referencedColumn yang menunjukkan reference dari foreign key tersebut. Untuk nullable sendiri adalah tanda yang akan menunjukkan bahwa tidak terdapat  null untuk kondisi true maupun false. Perbedaan nullable dengan anotasi NotNull adalah jika NotNull akan menjadi suatu batasan yang tidak akan memberikan memperbolehkan null values terhadap constrained field, sedangkan nullable hanya menjadi tanda untuk memberikan kita informasi apakah suatu variabel atau method mengandung null.

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER
FetchType.LAZY → kegunaannya adalah untuk hanya mengambil data ketika diakses atau sedang dibutuhkan. Contohnya ketika kita ingin mengambil data dari seorang pegawai dari database perusahaan
FetchType.EAGER → ini merupakan kebalikan dari FetchType.LAZY, dimana ketika kita membutuhkan data, maka akan diambil secara keseluruhan saat parent nya diambil. Contohnya ketika kita membutuhkan data terkait database perusahaan, dimana secara otomatis kita akan data pegawainya juga.

Referensi :
https://javabydeveloper.com/category/lombok/
https://docs.jboss.org/hibernate/jpa/2.1/api/javax/persistence/JoinTable.html
https://docs.jboss.org/hibernate/jpa/2.1/api/javax/persistence/JoinColumns.html
https://www.baeldung.com/java-bean-validation-not-null-empty-blank
https://stackoverflow.com/questions/2990799/difference-between-fetchtype-lazy-and-eager-in-java-persistence-api

---
## Tutorial 2
### What I have learned today
--> Pada tutorial kali ini saya mempelajari lebih dalam penggunaan framework spring karena telah mengimplementasikan method-method sendiri. Karena hal tersebut saya menjadi lebih paham bagaimana konsep MVC bekerja ketika mempassing data dari satu tempat ke tempat lainnya. Pemahaman saya untuk saat ini adalah di Model adalah dimana tempat data model dibuat dan disimpan, yang dengan begitu ketika kita ingin membuat logic untuk suatu program di Service kita akan menggunakan method getter & setter yang telah dibuat di Model. Setelah logic berhasil dibuat di Service, kita akan memanggil logic tersebut di Controller yang akan memproses routing url, passing data yang diproses ke HTML, dan juga akan mengembalikan halaman HTML yang telah dibuat.

Pertanyaan 1: Cobalah untuk menambahkan sebuah Kebun dengan mengakses link berikut setelah menjalankan program: http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung% 20Fasilkom&noTelepon=081xxx, Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi
--> Akan muncul white label error page, dengan pesan “This application has no explicit mapping for /error, so you are seeing this as a fallback”. Hal tersebut terjadi karena html “add-kebun-safari” belum dibuat. Untuk mengatasi error tersebut kita harus membuat file HTML “add-kebun-safari” di folder template.

Pertanyaan 2: Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat
--> Anotasi @Autowired digunakan agar kita tidak perlu membuat argumen untuk constructor ataupun method setter, hal tersebut dapat terjadi karena anotasi ini bekerja dengan cara melihat isi package yang sedang running, kemudian akan mencari clas-clas dengan anotasi seperti @Controller, @Service, @Component, dan @Repository. Lalu akan dilakukan inisiasi terhadap class-class tersebut dan akan menginjeksi dependenciesnya. Oleh karena itu anotasi @Autowires bekerja dengan mengimplementasi dari konsep dependency injection.

Pertanyaan 3: Cobalah untuk menambahkan sebuah Kebun dengan mengakses link berikut: http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung% 20Fasilkom Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
--> Muncul white label error page dan terdapat pesan “Required request parameter 'noTelepon' for method parameter type String is not present”. Hal tersebut terjadi karena dari link yang diberikan belum terdapat parameter “noTelepon”. Oleh karena itu, kita harus menambahkan noTelepon sesuai dengan parameter yang diminta oleh program.

Pertanyaan 4: Jika Papa APAP ingin melihat Kebun Safari dengan nama Papa APAP, link apa yang harus diakses?
—-> Untuk melihat Kebun Safari dengan nama Papa APAP kita dapat menakses dengan url sebagai berikut : http://localhost:8080/kebun-safari?id=1. Kita menggunakan URL tersebut karena pada Controller kita menggunakan @RequestParam. Oleh karena itu, kita harus menambahkan “?id=1”, dimana Kebun Safari dengan nama Papa APAP memiliki ID = 1.

Pertanyaan 5: Tambahkan 1 contoh Kebun Safari lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/ , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.
→ Saya mencoba menambahkan Kebun Safari lain dengan nama Ikmal’s Zoo, alamat Puncak Bogor, dan nomor telepon 08112234. Setelah saya buat dan membuka http://localhost:8080/, Data baru telah berhasil dibuat dan ditampilkan. Berikut link untuk screenshotnya : https://ibb.co/pRgZfg1

### Referensi
- https://software.endy.muhardin.com/java/memahami-dependency-injection/

---
## Tutorial 1
### What I have learned today
--> Hari ini saya telah belajar banyak mengenai penggunan git secara lebih advance seperti masalah branching dan pull request yang 
    ditujukan agar code yang kita buat dapat dimaintain secara lebih baik dan efektif. Setelah itu saya juga bertemu kembali dengan
    framework Spring yang sebelumnya telah saya temui di DDP-2, namun kali ini kita gali lebih dalam lagi proses yang tejadi dalam penggunaan framework spring secara best practicesnya dalam model MVC.
### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
--> Issue tracker adalah sebuah alat tracking yang terintegrasi dengan repository github, tool ini berguna untuk memaintain project yang sedang dikerjakan agar kita tetap on-track dan up to date terhadap hal-hal yang harus diselesaikan.
2. Apa perbedaan dari git merge dan git merge --squash?
--> Keduanya merupakan sama-sama memiliki fungsi untuk menyatukan perubahan pada program dari setiap branch yang ada
    disuatu project. Namun, perbedaannya adalah jika pada git merge, branches tetap akan mempertahankan riwayat perubahannya dan hanya akan mem-merge commit yang muncul, yang kemudian akan muncul lebih dari satu parent. Sedangkan untuk git merge --squash, branches juga akan tetap memperthanakan riwayat perubahannya, tetapi merge commit tidak akan ditampilkan. Untuk semua perubahan pada master akan disatukan dalam satu commit dan akan hanya tersisa satu parent.
3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?
--> 1. Fleksibilitas, Mendukung beberapa jenis alur kerja pengembangan nonlinear dan efisiensi dalam skala kecil maupun besar.
    2. Security, Git dibuat dengan menaja integritas source code, dimana setiap hubungan anatara file, directory, commit, version,
    dan lain-lain diberi sistem keamanan menggunakan algoritma SHA1 yang akan melindungi kode change history dari kerusakan yang
    tidak sengajan maupun berbahaya.
    3. Widely used, dimana git telah digunakan oleh banyak orang sehingga community tercipta yang membuat apabila terdapat masalah-
    masalah yang muncul kita bisa bertanya kepada orang-orang yang juga mungkin memiliki masalah yang sama.
    4. Feature Branch Workflow, setiap orang disatu project dapat diassign terhadap tugasnya masing-masing yang dapat dipisahkan 
    melalui branch masing-masing, sehingga setiap orang bisa fokus menyelesaikan tugasnya masing-masing secara bersamaan.
    5. Pull Request, Fitur ini berguna untuk menaggabungkan salah satu branch dengan repository yang lain. Hal ini memudahkan orang-
    orang di project tersebut untuk memonitor dan mentrack apabila terdapat perubahan suatu code.
### Spring
4. Apa itu library & dependency?
--> Library adalah sekumpulan fungsi, program, script, dan file yang dapat kita reuse dalam program kita. Unutk depedency sendiri
    adalah sebuah istilah dalam pemrograman yang menggambarkan ketergantungan suautu program dengan program lainnya agar bisa 
    berjalan dan bekerja. Library dan dependency sendiri memeiliki keterkaitan, dimana apabila suatu program A menggunakan library B, yang maksudnya adalah program A tersebut memiliki dependency terhadap B atau A adalah dependency dari B.
5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven? 6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
--> Maven adalah sebuat alat manajemen proyek yang berdasar pada Project Object Model (POM) yang digunakan untuk mempermudah
    pengelolaan dan pembangunan sebuah project dengan basis bahasa Java. Apabila kita mengerjakan suatu project yang memiliki banyak dependencies dan requirement akan sangat sangat sulit, oleh karena itu dengan maven kita dapat menambahkan semua dependency yang kita perlukan secara otomatis dengan membaca file POM. Selain maven kita dapat menggunakan Jenkins, GNU Make, Gradle, dan lain-lain.
6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
--> Spring framework bisa kita manfaatkan juga untuk melakukan testing, data accessing, pengembangan aplikasi perusahaan dengan 
    Plain Old Java Object (POJO). Selain itu Spring framework juga bisa kita gunakan untuk pengembangan aplikasi standalone, GUI 
    standalone, aplikasi berbasi MVC, dan lain-lain.
7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?
--> Kedua hal tersebut digunakan untuk path URL yang akan kita gunakan di web kita. Untuk anotasi @RequestParam digunakan 
    untuk mengekstrak data yang ditemukan dalam parameter query, ex : "/is-palindrome?kalimat=isi". Anotasi ini akan lebih baik digunakan ketika ingin mengikat parameter request ke argumen pada handler method secara otomatis. Sedangkan untuk anotasi @PathVariable digunakan untuk mengekstrak data dari template URI yang contohnya adalah RESTful web services. Anotasi ini akan 
    lebih baik kita gunakan ketuka ingin melakukan customization untuk mendapatkan data karena spring MVC mendukung penyesuaian pada URL.
### What I did not understand
- [x] Kenapa saya harus belajar APAP?
--> APAP berguna sekali untuk melatih kita untuk melakukan pembuatan program dengan mengikuti prinsip OOP, sehingga data akan lebih mudah untuk dibaca, diupgarde, dan dimanage. Hal ini akan sangat berguna untuk pembuatan program atau sistem dengan skala yang besar dimana apabila tidak dibuat dengan prinsip OOP akan lebih sulit untuk memanage dan mengupdate code yang ada saat ini.
- [x] Kenapa untuk project skala enterprise, spring framework meruapakan salah satu framework yang direkomendasikan dan kita gunakan?
--> Karena untuk skala enterprise kompleksitas programnya sudah cukup besar, dan Spring bekerja dengan prinsip OOP dimana program akan lebih mudah dimanage dan dikembangkan kedepannya.
### Referensi
- https://www.ibm.com/garage/method/practices/think/tool_github_issues/
- https://guide.quickscrum.com/git-guide/
