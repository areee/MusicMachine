# MusicMachine-ohjelman käyttöohjeet 

## Ohjelman käynnistys
1. Käynnistä ohjelma komentorivin (Terminal) kautta MusicMachine-1.0.jar-tiedostosta (komentorivillä hakeudu MusicMachine-kansioon ja syötä ```java -jar MusicMachine-1.0.jar```).
2. Valitse komentorivillä käynnistettävä käyttöliittymä joko syöttämällä ```1``` (graafinen käyttöliittymä) tai ```2``` (tekstikäyttöliittymä). Voit myös sulkea ohjelman syöttämällä ```x```.

## Graafisen käyttöliittymän käyttö

### Lisää yksi äänitiedosto tai useita äänitiedostoja soittolistalle
1. Klikkaa "Lisää äänitiedosto"-painiketta ([+]-painike).
2. Etsi avautuvasta valintaikkunasta toistettava äänitiedosto (ohjelma tukee WAV-, MIDI- ja AIFF-tiedostoja). Klikkaa haluamasi äänitiedosto valituksi ja klikkaa "Lisää"-painiketta. Valittu äänitiedosto ilmestyy soittolistalaatikkoon.
3. Voit halutessasi lisätä soittolistalle useita äänitiedostoja toistamalla vaiheet 1 ja 2.

### Toista äänitiedostoa
1. Lisää yksi äänitiedosto / useita äänitiedostoja soittolistalle (ks. [edellinen kohta)](#lisää-yksi-äänitiedosto-tai-useita-äänitiedostoja-soittolistalle)).
2. Ohjelman perusnäkymässä klikkaa valituksi äänitiedosto, jota haluat toistaa. Klikkaa "Toista"-painiketta (vino kolmio -kuvake). Äänitiedosto alkaa soida.

### Pysäytä äänitiedosto
1. Toiston ollessa käynnissä tai tauolla klikkaa "Pysäytä"-painiketta. Äänitiedoston toisto päättyy.

### Siirrä toisto haluttuun toistokohtaan
1. Laita äänitiedosto soimaan (ks. [Toista äänitiedostoa](#toista-äänitiedostoa)).
2. Äänitiedoston toiston aikana tai sen ollessa tauko-tilassa klikkaa liukusäätimestä haluamaasi kohtaa (tai tartu kiinni liukusäätimen toistokohdasta ja vedä se haluamaasi kohtaan). Äänitiedoston toisto siirtyy valitsemaasi kohtaan.

### Aseta äänitiedosto tauko-tilaan
1. Laita äänitiedosto soimaan (ks. [Toista äänitiedostoa](#toista-äänitiedostoa)).
2. Toiston aikana klikkaa "Tauko"-painiketta (kaksi pystyviivaa -kuvake). Äänitiedosto siirtyy tauko-tilaan. Tauko-tilassa voit halutessasi siirtää toiston haluamaasi toistokohtaan (ks. [Siirrä toisto haluttuun toistokohtaan](#siirrä-toisto-haluttuun-toistokohtaan)).
3. Poistu tauko-tilasta joko pysäyttämällä kokonaan toisto (ks. [Pysäytä äänitiedosto](#pysäytä-äänitiedosto)) tai klikkaamalla "Toista"-painiketta, jolloin äänitiedoston toisto jatkuu liukusäätimen toistokohdasta.

### Kelaa äänitiedostoa
1. Laita äänitiedosto soimaan (ks. [Toista äänitiedostoa](#toista-äänitiedostoa)).
2. Jos haluat kelata äänitiedostoa eteenpäin, klikkaile "Kelaa eteenpäin" -painiketta. Äänitiedosto kelautuu jokaisella klikkauksella hieman eteenpäin ja kelaamisen aikana toisto kuulostaa nopeutetulta.
3. Jos haluat kelata äänitiedostoa taaksepäin, klikkaile "Kelaa taaksepäin" -painiketta. Äänitiedosto kelautuu jokaisella klikkauksella hieman taaksepäin ja kelaamisen aikana toisto kuulostaa hidastetulta.

### Soittolistan tyhentäminen, yksi tai useita äänitiedostoja
1. Varmista, että soittolistallasi on yksi tai useita äänitiedostoja lisättynä ja valittuna (ks. [Lisää yksi äänitiedosto tai useita äänitiedostoja soittolistalle](#lisää-yksi-äänitiedosto-tai-useita-äänitiedostoja-soittolistalle)-kohta).
2. Klikkaa "Poista äänitiedosto" -painiketta ([-]-painike). Valitsemasi äänitiedosto katoaa soittolistalta.
3. Jos haluat poistaa useita äänitiedostoja, voit joko poistaa ne yksitellen "Poista äänitiedosto" -painiketta klikkailemalla tai tyhjentää koko soittolistan klikkaamalla "Tyhjennä soittolista" -painiketta.


### Soittolistan tallentaminen
1. Varmista, että soittolistallasi on yksi tai useita äänitiedostoja lisättynä (ks. [Lisää yksi äänitiedosto tai useita äänitiedostoja soittolistalle](#lisää-yksi-äänitiedosto-tai-useita-äänitiedostoja-soittolistalle)-kohta).
2. Klikkaa "Tallenna soittolista" -painiketta.
3. Valitse aukeavassa tiedostontallennusikkunassa sijainti tallennettavalle soittolistalle (oletuksena kansio, jossa itse ohjelman jar-tiedosto sijaitsee).
4. Kirjoita "Save As" -tekstikenttään nimi soittolistalle. HUOM! samassa kansiossa ei saa olla nimeämäsi soittolistan kanssa samannimistä (.txt-päätteisiä) tiedostoa, muuten se tuhoutuu ja korvautuu luomallasi soittolistalla!
	* Voit antaa soittolistan tallennusnimen joko muodossa "nimi.txt" tai muodossa "nimi".
	* Vinkki! Jos haluat korvata aiemmin luodun soittolistan uudella soittolistalla, valitse tallennusikkunassa kyseinen soittolista. "Save as" -tekstikenttään ilmestyy kyseisen soittolistan tiedostonimi.
5. Klikkaa "Tallenna"-painiketta. Ohjelma tallentaa soittolistan valitsemaasi sijaintiin valitulla nimellä.

### Aiemmin tallennetun soittolistan avaaminen
1. Klikkaa "Avaa soittolista" -painiketta. 
2. Etsi avautuvasta valintaikkunasta toistettava soittolista (tekstitiedostomuodossa). Klikkaa haluamasi soittolista valituksi ja klikkaa "Avaa"-painiketta.
3. Soittolista latautuu tiedostosta soittolistalaatikkoon.

## Tekstikäyttöliittymän käyttö

### Valitse toistettava äänitiedosto
1. Syötä komentoriville komento ```1```.
2. Valitse toistettava äänitiedosto.
	- Jos haluat ohjeita äänitiedoston tiedostopolun syöttämisestä, syötä ```?``` tai paina näppäimistön Enter-näppäintä.
3. Ohjelma asettaa äänitiedoston toistovalmiiksi.

### Toista äänitiedostoa
1. Syötä komentoriville komento ```2```.
2. Äänitiedoston toisto käynnistyy.

### Aseta äänitiedosto tauko-tilaan
1. Syötä komentoriville komento ```3```.
2. Äänitiedosto asettuu tauko-tilaan.
3. Poistu tauko-tilasta syöttämällä komento ```2``` (toista), ```5``` (lopeta äänitiedoston toisto) tai ```6``` (lopeta ohjelma).

### Äänitiedoston tiedot
1. Syötä komentoriville komento ```4```.
2. Komentoriville tulostuu äänitiedoston nimi, tiedostopolku ja kesto.

### Lopeta äänitiedoston toisto
1. Syötä komentoriville komento ```5```.
2. Äänitiedoston toisto päättyy, mutta ohjelma ei sulkeudu. Voit valita jonkin toisen äänitiedoston toistettavaksi.

### Lopeta ohjelma
1. Syötä komentoriville komento ```6```.
2. Ohjelma sulkeutuu.
