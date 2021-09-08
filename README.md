# Tutorial APAP
## Authors
* **Ikmal Almuhtadi Rajab** - *1906308324* - *APAP - A*

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
- [ ] Kenapa saya harus belajar APAP?
- [ ] Kenapa untuk project skala enterprise, spring framework meruapakan salah satu framework yang direkomendasikan dan kita gunakan?
### Referensi
- https://www.ibm.com/garage/method/practices/think/tool_github_issues/
- https://guide.quickscrum.com/git-guide/
