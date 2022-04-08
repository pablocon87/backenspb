
function insertAfter(newNode, existingNode) {
    if(existingNode !==null){
            existingNode.parentNode.insertBefore(newNode, existingNode.nextSibling);
       }
    }
function Grafico(porcentaje,sobre,de,conta) {
    
   
   /* if( document.getElementsByTagName("div")[1] !== undefined ) {
     
     
                    var rdiv=document.getElementsByTagName("div");
                    let conta=0;
                    for (let i=0;i<rdiv.length;i++) {
                        conta+=1;
                        if(conta>4){
                    rdiv[conta].parentNode.removeChild(rdiv[conta]);
                            }
                        }
      var brs = document.getElementsByTagName("br");
                             while (brs.length) {
                                brs[0].parentNode.removeChild(brs[0]);
                              }
      
                    var rli = document.getElementsByTagName("li");
                             while (rli.length) {
                                rli[0].parentNode.removeChild(rli[0]);
                              }
                              var rul = document.getElementsByTagName("ul");
                             while (rul.length) {
                                rul[0].parentNode.removeChild(rul[0]);
                              }
                              var rp = document.getElementsByTagName("p");
                             while (rp.length) {
                                rp[0].parentNode.removeChild(rp[0]);
                              }
                              var rh = document.getElementsByTagName("h2");
                             while (rh.length) {
                                rh[0].parentNode.removeChild(rh[0]);
                              }
                              var rsp = document.getElementsByTagName("span");
                             while (rsp.length) {
                                rsp[0].parentNode.removeChild(rsp[0]);
                              }}*/

    let result=(porcentaje*360)/100;
    let para="";
         
        // create a new li node
       
        
                 para = document.createElement("div");
                para.setAttribute("class","donut-chart-block block");     
                para.setAttribute("id","donus"+conta);    
                para.innerHTML = sobre;
                
               
                document.getElementById("div"+conta).appendChild(para);
                
            para="";
           para = document.createElement("h2");
            para.setAttribute("class","titular");     
            para.setAttribute("id","titular"+conta);    
            para.innerHTML = sobre;
            document.getElementById("donus"+conta).appendChild(para);
            para="";
             para = document.createElement("div");
            para.setAttribute("class","donut-chart");       
            para.setAttribute("id","donut-chart"+conta);  
            document.getElementById("titular"+conta).appendChild(para);
            
            para="";
            let ress=0;
            let res=0;
            let r2=0;
            if(result>=180){
                 ress=180;
               let r=360-result;
               res=r;
               r2=360-res;
                result=180-r;
                para=""   ;
                          
                para = document.createElement("div");  
                para.setAttribute("id","porcion11"+conta);  
                  para.setAttribute("class","recorte");   
                   para.setAttribute("style","transform: rotate(180deg);!important");
                document.getElementById("donut-chart"+conta).appendChild(para);
            
            para=""   ;              
            para = document.createElement("div");  
            para.setAttribute("class","quesito ios2");  
            para.setAttribute("id","ques"+conta);
            para.setAttribute("style","background-color: #E64C65;transform: rotate("+result+"deg);!important");       
            document.getElementById("porcion11"+conta).appendChild(para);
            para="";
            }else{

                if(result<=180){
                    r2=result;
                    res=180-result;
                    para = document.createElement("div");
                    para.setAttribute("id","porcion22"+conta);   
                    para.setAttribute("class","recorte"); 
                        
                    para.setAttribute("style","transform: rotate("+r2+"deg);!important");          

                    document.getElementById("donut-chart"+conta).appendChild(para);
                    para="";
                    para = document.createElement("div");  
                    para.setAttribute("class","quesito mac2");
                    para.setAttribute("id","ques2"+conta);
                    para.setAttribute("style","background-color: #11A8AB;transform: rotate("+res+"deg);!important");          
                    document.getElementById("porcion22"+conta).appendChild(para);


                }
                


                r2=result;
                ress=result;
                res=360-result;
                if (res>=180){
                    r2=180;
                    res=180;
                   //ress=180;
                }

                
            }
                para="";
             para = document.createElement("div");
            para.setAttribute("id","porcion1"+conta);
             para.setAttribute("style","transform: rotate(0deg);!important");
            para.setAttribute("class","recorte");       
            document.getElementById("donut-chart"+conta).appendChild(para);
             para = document.createElement("div");  
            para.setAttribute("class","quesito ios");  
            para.setAttribute("id","ios"+conta)
            para.setAttribute("style","background-color: #E64C65;transform: rotate("+ress+"deg);!important");       
            document.getElementById("porcion1"+conta).appendChild(para);
            
            
             
             para = document.createElement("div");
            para.setAttribute("id","porcion2"+conta);   
            para.setAttribute("class","recorte");     
            para.setAttribute("style","transform: rotate("+r2+"deg);!important");      
            document.getElementById("donut-chart"+conta).appendChild(para);
            para="";
             para = document.createElement("div");  
            para.setAttribute("class","quesito mac");
            para.setAttribute("id","mac"+conta);
            para.setAttribute("style","background-color: #11A8AB;transform: rotate("+res+"deg);!important");          
            document.getElementById("porcion2"+conta).appendChild(para);
            
            
            


            para="";
             para = document.createElement("p");  
            para.setAttribute("class","center-date"); 
            para.setAttribute("id","center-date"+conta);
            para.innerHTML = de;      
            document.getElementById("donut-chart"+conta).appendChild(para);
            para="";
             para = document.createElement("br");
             para.setAttribute("id","br"+conta)
            document.getElementById("center-date"+conta).appendChild(para);
            para="";
             para = document.createElement("span");   
            para.setAttribute("class","scnd-font-color"); 
            para.setAttribute("id","span"+conta); 
            para.innerHTML="2013";
            document.getElementById("br"+conta).appendChild(para);
            para="";
             para = document.createElement("ul");
            para.setAttribute("class","os-percentages horizontal-list");   
            para.setAttribute("id","ul"+conta);      
            document.getElementById("donus"+conta).appendChild(para);
            para="";
             para = document.createElement("li");  
             para.setAttribute("id","li"+conta)
            document.getElementById("ul"+conta).appendChild(para);
            para="";
             para = document.createElement("p");  
            para.setAttribute("class","ios os scnd-font-color") ; 
            para.setAttribute("id","p"+conta);
            para.innerHTML=de; 
            document.getElementById("li"+conta).appendChild(para);
            para="";
             para = document.createElement("p");  
            para.setAttribute("class","os-percentage");   
            para.setAttribute("id","p2"+conta);
            para.innerHTML=porcentaje+"%";
            document.getElementById("li"+conta).appendChild(para);
            para="";    
             para = document.createElement("li");    
             para.setAttribute("id","li2"+conta)
            document.getElementById("ul"+conta).appendChild(para);
            para="";
             para = document.createElement("p");  
            para.setAttribute("class","mac os scnd-font-color") ;
            para.setAttribute("id","p3"+conta);
            para.innerHTML="Falta" 
            document.getElementById("li2"+conta).appendChild(para);
            para="";
             para = document.createElement("p");  
            para.setAttribute("class","os-percentage"); 
            para.setAttribute("id","p4"+conta);
            let porc=100 -porcentaje;   
            para.innerHTML=porc+"%";
            document.getElementById("li2"+conta).appendChild(para);
return ;
        }