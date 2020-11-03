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
 
* GET /tasks : megadja a Task-okat
* GET /tasks/id/descriptions : megadja egy Task-hoz lévő Description-oket
* GET /familys : megadja a Family-ket
* GET /familys/id/users : megadja egy Family-het tartozó User-eket
* GET /users : megadja a User-eket
* GET /users/id/tasks : megadja egy User-hez tartozó Task-okat
* GET /messagess : megadja a Description-oket
* POST /tasks : Új Task létrehozása
* POST /tasks/id/messagess : egy Task-hoz új Description létrehozása
* POST /familys : Új Family létrehozása
* POST /familys/id/users : egy Family-hez új User hozzáadása
* POST /users : Új User létrehozása
* POST /users/id/tasks : egy User-hez új Task hozzáadása
* POST /messagess : Új Description létrehozása 
* POST /users/login : Felhasználó bejelentkezése 
* POST /users/register : Felhasználó regisztrálása
* PUT /tasks/id : egy Task szerkesztése
* PUT /familys/id : egy Family szerkesztése
* PUT /users/id : egy User szerkesztése
* PUT /users/id/tasks : egy User-hez tartozó Task szerkesztése
* PUT /messages/id : egy Description szerkesztése
* DELETE /tasks/id : Egy Task törlése
* DELETE /familys/id : egy Family törlése
* DELETE /users/id : egy User törlése
* DELETE /messagess/id : egy Description törlése 
