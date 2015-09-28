var counter = 1;
var limit = 3;
function addRoom(divName){
     if (counter == limit)  {
          alert("超过" + counter + "间客房请重新预订");
     }
     else {
          var newdiv = document.createElement('div');
          var aName = "adult" + counter;
          var cName = "child" + counter;
         
          newdiv.innerHTML = "房间 " + (counter + 1) + " <br><span>成人：</span>"+
        "<SELECT id="+aName+" onChange='getChild(\""+aName+"\",\""+cName+"\")' style='width:100px'>"+
             "<OPTION VALUE='0'>成人数 </OPTION>"+
            " <OPTION VALUE='1'>1</OPTION>"+
            " <OPTION VALUE='2'>2</OPTION>"+
            " <OPTION VALUE='3'>3</OPTION></SELECT>"+
                " <span>儿童：</span><SELECT id="+cName+" style='width:100px'><OPTION VALUE='0'>儿童数    </OPTION> </SELECT>"+
              "";
          document.getElementById(divName).appendChild(newdiv);
          counter++;
     }
}