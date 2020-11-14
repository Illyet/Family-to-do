# FAMILY TO-DO LIST    
   
## funkcionális követelmények  
 
Családtagok :

-  Saját feladat felvétele saját listára (csak az adott családtag végezheti el)
-  Saját listán szereplő feladatok lekérdezése 
-  Saját feladat törlése a saját listáról (ami már elvégezve lett)
-  Megjegyzés fűzése saját feladathoz

Családfők :
- Összes lista lekérdézése (saját és közös)
- Közös feladat felvétele közös listára (bárki elvégezheti)
- Saját feladat felvétele nem saját listára
- Saját feladat felvétele saját listára
- Feladat törlése saját listáról
- Megjegyzés fűzése saját feladathoz
- Megjegyzés fűzése közös feladathoz

 
## Szerepkörök   

Vendég: főoldal látogatása 
Családtag: a vendég szerepkörén túl feladatot tud felvenni, törölni(teljesíteni), megjegyzést tud fűzni a feladatokhoz illetve képes megtekinteni őket.  
Családfő: a családtag szerepkörén túl az összes feladatot meg tudja tekinteni. Képes saját és közös feladatok kiírására, illetve ezekhez megjegyzést fűzni.    
  

 ## ARC
 
* GET /tasks : megadja a Task-okat ADMIN USER
* GET /tasks/id/descriptions : megadja egy Task-hoz lévő Message-ket ADMIN USER
* GET /familys : megadja a Family-ket ADMIN
* GET /familys/id/users : megadja egy Family-hez tartozó User-eket ADMIN
* GET /users : megadja a User-eket ADMIN
* GET /users/id/tasks : megadja egy User-hez tartozó Task-okat ADMIN USER
* GET /messagess : megadja a Message-ket ADMIN
* POST /tasks : Új Task létrehozása ADMIN
* POST /tasks/id/messagess : egy Task-hoz új Description létrehozása ADMIN
* POST /familys : Új Family létrehozása ADMIN
* POST /familys/id/users : egy Family-hez új User hozzáadása ADMIN
* POST /users : Új User létrehozása ADMIN USER
* POST /users/id/tasks : egy User-hez új Task hozzáadása ADMIN
* POST /messagess : Új Message létrehozása ADMIN USER
* POST /api/auth : User vagy Admin tokengenerálása
* PUT /tasks/id : egy Task szerkesztése ADMIN USER
* PUT /familys/id : egy Family szerkesztése ADMIN
* PUT /users/id : egy User szerkesztése ADMIN USER
* PUT /users/id/tasks : egy User-hez tartozó Task szerkesztése ADMIN USER
* PUT /messages/id : egy Message szerkesztése ADMIN USER
* DELETE /tasks/id : Egy Task törlése ADMIN
* DELETE /familys/id : egy Family törlése ADMIN
* DELETE /users/id : egy User törlése ADMIN
* DELETE /messagess/id : egy Message törlése ADMIN USER
