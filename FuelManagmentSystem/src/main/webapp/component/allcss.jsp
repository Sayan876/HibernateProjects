<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
	integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />



<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>




<style>

*{
  margin:0;
  padding: 0;
  box-sizing: border-box;
}

h3{
  text-align: center;
}
.nevi {
	position: fixed;
	width: 100%;
	background-color:red;
	z-index: 9999;
}

#sells {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#sells td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#sells tr:nth-child(even){background-color: #f2f2f2;}

#sells tr:hover {background-color: #ddd;}

#sells th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
.box{
   height:250px;
   width:100%;
   display: flex;
   justify-content: space-around;
   align-items: center;
}
.box>div{
  height: 180px;
  width:180px;
  border: 1px solid rgba(0,0,0,0);
  border-radius: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
  
}

.box2{
   height:30px;
   width:100%;
   display: flex;
   justify-content: space-around;
   align-items: center;

}

.box2>div{
  
  width:180px;
  background-color: grey;
  border: 1px solid rgba(0,0,0,0);
  border-radius: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
  
  
}

.box2>div>a{
  text-decoration: none;
  color:white;
  
}

.mainform{
  height:550px;
  width:100%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.mainform>section{
  height:100%;
  width:40%;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: rgba(255, 255, 255, 0.562);
  backdrop-filter: blur(5px);
  box-shadow: 0px 0px 10px black;
  border: 1px solid rgba(0,0,0,0);
  border-radius: 20px;
}


td{
  height:50px;
  width: 170px;
   

}

td>button{

  width:100%;
  height:30px;
  border:1px solid rgba(0,0,0,0);
  border-radius:10px;
  
  background-color: #06c910;
  color:white;
}

td>input{
  width:200px;
  height:40px;
  background-color:#eff2ed;
  border:1px solid rgba(0,0,0,0);
  outline:none;
  border-radius:10px;
  padding: 10px;
  

}

.userform{
height:100vh;
width:100%;

display: flex;
justify-content: center;
align-items: center;
}

.userform>section{
height:70%;
width:70%;

display: flex;
justify-content: center;
align-items: center;
}

.userform>section>form{
height:95%;
width:35%;

display: flex;
align-items: center;
justify-content:center;
flex-direction: column;
border:1px solid rgba(0,0,0,0);
border-radius: 25px;
box-shadow: 0px 0px 20px black;
background-color: rgba(255, 255, 255, 0.562);
  backdrop-filter: blur(5px);
}

.userform>section>form>input{
margin:25px;
height:40px;
width:80%;
border:1px solid rgba(0,0,0,0);

 background-color:#eff2ed;
border-radius: 10px;
padding: 10px;
}

.userform>section>form>button{
margin-top: 20px;
height:30px;
  border:1px solid rgba(0,0,0,0);
  border-radius:10px;
  width:80%;
  background-color: #06c910;
  color:white;
}

</style>
