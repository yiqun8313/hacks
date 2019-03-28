var jin = new Array(0,0,0,0,0,0,0,0,0,0);
var XorO = 0;

var gameover = false;
var player_won = 0;
var player2_won = 0;
var draw =0;

var playerOne="";
var playerTwo="";
 


function setName(){


	playerOne = document.getElementById("name1").value;
	playerTwo = document.getElementById("name2").value;

	document.getElementById("playerone").value=playerOne;
	document.getElementById("playertwo").value=playerTwo;

	document.getElementById("name1").disabled=true;
	document.getElementById("name2").disabled=true;






	document.getElementById("bt1").value="  ";
	document.getElementById("bt2").value="  ";
	document.getElementById("bt3").value="  ";
	document.getElementById("bt4").value="  ";
	document.getElementById("bt5").value="  ";
	document.getElementById("bt6").value="  ";
	document.getElementById("bt7").value="  ";
	document.getElementById("bt8").value="  ";
	document.getElementById("bt9").value="  ";
	

	

	
}

function bn(i){

   if(playerOne == "" || playerTwo == "") {
	   alert("Please input player name");
	   restart();
   }



	if(jin[i]!=0 || gameover)return ;
	if(XorO==0){
		if(i==1)document.getElementById("bt1").value="O";
		else if(i==2)document.getElementById("bt2").value="O";
		else if(i==3)document.getElementById("bt3").value="O";
		else if(i==4)document.getElementById("bt4").value="O";
		else if(i==5)document.getElementById("bt5").value="O";
		else if(i==6)document.getElementById("bt6").value="O";
		else if(i==7)document.getElementById("bt7").value="O";
		else if(i==8)document.getElementById("bt8").value="O";
		else if(i==9)document.getElementById("bt9").value="O";
		jin[i]=1;
	}
	else{
		if(i==1)document.getElementById("bt1").value="X";
		else if(i==2)document.getElementById("bt2").value="X";
		else if(i==3)document.getElementById("bt3").value="X";
		else if(i==4)document.getElementById("bt4").value="X";
		else if(i==5)document.getElementById("bt5").value="X";
		else if(i==6)document.getElementById("bt6").value="X";
		else if(i==7)document.getElementById("bt7").value="X";
		else if(i==8)document.getElementById("bt8").value="X";
		else if(i==9)document.getElementById("bt9").value="X";
		jin[i]=-1;
	}
	cgTurn();
}

function cgTurn(){
	var sum=0;
	for(var i=0;i<10;i++)if(jin[i]!=0)sum++;
	
	if( checkWin() == true ){
		gameover=true;
		if(XorO==0){
			let cur=playerOne+" "+"victory";
			document.getElementById("info").value=cur;
			player_won++;
			balance();
		}
		else {
			let cur=playerTwo+" "+"victory";
			document.getElementById("info").value=cur;
			player2_won++;
			balance();
			
		}
		return ;
	}
	if(sum==9){
		document.getElementById("info").value="draw!";
		draw++;
		balance();
		return ;
	}
	
	
	//轮次
	XorO=(XorO+1)%2;
	if(XorO==0){
		let cur="Turn to"+" "+playerOne;
		document.getElementById("info").value=cur;
	}
	else {
		let cur="Turn to"+" "+playerTwo;
		document.getElementById("info").value=cur;
		
	}
}
//胜利条件
function checkWin(){
	var num=false;
	if(jin[7]+jin[8]+jin[9]==-3 || jin[7]+jin[8]+jin[9]==3)return true;
	else if(jin[4]+jin[5]+jin[6]==-3 || jin[4]+jin[5]+jin[6]==3)return true;
	else if(jin[1]+jin[2]+jin[3]==-3 || jin[1]+jin[2]+jin[3]==3)return true;
	else if(jin[1]+jin[4]+jin[7]==-3 || jin[1]+jin[4]+jin[7]==3)return true;
	else if(jin[2]+jin[5]+jin[8]==-3 || jin[2]+jin[5]+jin[8]==3)return true;
	else if(jin[3]+jin[6]+jin[9]==-3 || jin[3]+jin[6]+jin[9]==3)return true;
	else if(jin[1]+jin[5]+jin[9]==-3 || jin[1]+jin[5]+jin[9]==3)return true;
	else if(jin[7]+jin[5]+jin[3]==-3 || jin[7]+jin[5]+jin[3]==3)return true;
}
function restart(){
	for(i=1;i<10;i++)jin[i]=0;
	document.getElementById("bt1").value="  ";
	document.getElementById("bt2").value="  ";
	document.getElementById("bt3").value="  ";
	document.getElementById("bt4").value="  ";
	document.getElementById("bt5").value="  ";
	document.getElementById("bt6").value="  ";
	document.getElementById("bt7").value="  ";
	document.getElementById("bt8").value="  ";
	document.getElementById("bt9").value="  ";
	document.getElementById("info").value="Start!"


//yiwen
	document.getElementById("playerone").value="  ";
	document.getElementById("playertwo").value="  ";

	document.getElementById("name1").value="  ";
	document.getElementById("name2").value="  ";

	document.getElementById("name1").disabled=false;
	document.getElementById("name2").disabled=false;

//jifen
    document.getElementById("o_win").value=0;
	document.getElementById("x_win").value=0;
	document.getElementById("draw").value=0;

	XorO = 0;
	gameover=false;
}

//结算、更新界面
function balance(){
	document.getElementById("o_win").value=player_won;
	document.getElementById("x_win").value=player2_won;
	document.getElementById("draw").value=draw;
}
