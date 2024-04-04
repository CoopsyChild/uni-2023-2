# GOF1 és GOF2

## GOF 1
Programozz felületre implementáció helyett. Program to an interface not an implementation. Szintaxis szintjén azt jelenti, hogy a statikus típus az a lehető legősibb, aminek az interface még jó. 

Kutyás példa:
- A: Kutya k1 = new Vadászkutya;
- B: Vadászkutya k1 = new Vadászkutya;

K1.Ugat();

Ha ugat metódus van a kutyában is, akkor az A a jó válasz.

## GOF 2
Favor object composition over class inheritance. Használj objektum összetételt öröklődés helyett, ha csak lehet.

Objektum összetétel szinonímái: 
- HAS-A kapcsolat
- becsomagolás 
- wrapping

Öröklődés szinonímája:
- IS-A kapcsolat.

GOF-2 átfogalmazva: Használj HAS-A kapcsolatot IS-A kapcsolat helyett, ha csak lehet.

###  HAS-A kapcsolat fajtái:
- Erősség szerinti osztályozás:
    - Leggyengeébb: barátság (asszociáció, ehhez nem kell mező)
    - Aggregáció: nem kizárólagos bírtoklás, (van egy gitárom, de az nem csak az enyém, más is használhatja.) Kell hozzá egy mező.
    - Kompozíció: (kizárólagos tualjdonlás, pl.: a kutyának van farka és csak ő csóválhatja)

- Átlátszósság szerinti osztályozás (2 szélsőség van):
    - Átlátszó: Ha a becsomagolás átlátszó, akkor a külső felületre kipublikálom a becsomagolt objektum minden szolgáltatását.
        - Proxy a legjobb példa, ami magyarul "helyettes", illetve a dekorátor (díszítő).
    - Nem átlátszó: A saját szolgáltatásaimhoz felhasználom a becsomagolt objektum szolgáltatásait, de azokat nem publikálom (csak a sajátom publikálom).
        - Tipikus példa az illesztő (adapter) fejlesztési minta.

###  Dekorátor tervezési minta

Alapötlet ha van egy karácsonyfám és arra felteszek egy díszt, attól az még karácsonyfa marad. Van egy ablakom, az ablakra felteszek egy görgető sávot, attól az még ablak marad. Van kéznél egy lucfenyő, gombdísz és egy csillag. Legrosszabb megoldás az lenne ha mindegyik kombóbol csinálnék egy külön osztályt.
Dísszel becsomagolom a karácsonyfát, de én még azt szeretném, hogy ez karácsonyfa maradjon, kell egy gondolati lépés. 

Ez csak úgy lehetséges ha a dísz, megörököl mindent amit egy karácsonyfa tud. Polimorfizmus akkor műküdik ha van öröklődés. Tehát a dísz karácsonyfa típusu.

Díszből mutat a KF-re a nyíl.

abstract karácsonyfa (UML-ben az az absztrakt ami dölt-el van írva)

Vagy egy absztrakt ősöm a Karácsonyfa, ennek két gyermekosztálya van, a Lucfenyő ami egy konkrét osztály és a dísz ami egy absztrakt osztály. A dísz becsomagol egy karácsonyfát ezzel érem el, mivel a dísz karácsonyfa típusú, ezért ez a becsomagolás átlátszó.

Az átlátszó becsomagoláshoz mindig kell IS-A és HAS-A kapcsolat is. Amikor a dísszel becsomagolom a karácsonyfát az azért lesz átlátszó mert a dísz is karácsonyfa típusu. Díszítőnek rokona a proxy, a proxy is átlátszó becsomagolást csinál.

A proxy azért átlátszó becsomagolás mert van benne IS-A (öröklődés) és HAS-A kapcsolat (wrapping) is. Becsomagol egy értékes megvalósítást, úgy hogy közös a felületük hiszen közös az ősük.

Külön tervezési minta a kompozíció, ennek egy speciális változata a bináris fa.