# Aihemäärittely

## Aihe: musiikin toisto- ja miksausohjelma
Aion toteuttaa ohjelman, joka osaa toistaa musiikkia ja jolla voi miksata sitä. Tavoitteenani on siis aikaansaada jonkinlainen laajennettavissa oleva, musiikkiin keskittyvä "media player"-ohjelma, jota esim. DJ voi käyttää keikoillaan.

## Käyttäjät:
- kaikki musiikin kuuntelijat

## Toiminnot:
- soittolistojen luominen
- musiikkitiedostojen (WAV, AIFF, MIDI jne.) lisääminen soittolistalle
- musiikkitiedostojen poisto soittolistalta
- musiikin toistaminen
- musiikin pistäminen tauolle
	- musiikki jatkuu siitä, mihin jäätiin, kun painetaan toista-painiketta
- musiikin kelaaminen

# Rakenne

Ohjelma rakentuu useista luokista, jotka ovat yksisuuntaisesti vuorovaikutuksessa keskenään.

1. Ohjelma käynnistyy, kun pääluokka MusicMachine suoritetaan. MusicMachine-luokka kutsuu ValitseKayttoliittyma-luokan kaynnista()-metodia, joka käynnistää tekstikäyttöliittymän.

2. ValitseKayttoliittyman kaynnista()-metodi kutsuu Lukija-luokkaa, joka palauttaa käyttäjän antaman komennon. Sen mukaan kutsutaan joko GraafinenKayttoliittyma-luokan setVisible(true)-metodia tai TekstiKayttoliittyma-luokan kaynnista()-metodia.

3. GraafinenKayttoliittyma-luokka vastaa graafisen käyttöliittymän ulkonäöstä. Kaikki muu ohjelman suoritus (ohjelman logiikka) suoritetaan Sovelluslogiikka-luokassa, jota GraafinenKayttoliittyma-luokka kutsuu aina tarvittaessa. Sovelluslogiikka-luokasta kutsutut arvot palautetaan sieltä arvoina takaisin GraafinenKayttoliittyma-luokkaan, jossa graafiset elementit hyödyntävät Sovelluslogiikka-luokasta saamiaan tietoja. GraafinenKayttoliittyma pystyy myös päivittämään Sovelluslogiikka-luokan arvoja. Sama pätee TekstiKayttoliittyma-luokkaan.

4. Kuten edellä jo kävi ilmi, Sovelluslogiikka-luokka vastaa ohjelman logiikasta. Sovelluslogiikka-luokka luo aina tiedostoa valitessa uuden Aanitiedosto-luokan, jota Sovelluslogiikka kutsuu aina tarvittaessa. Aanitiedosto-luokan sisältämien arvojen kyselyn lisäksi Sovelluslogiikka pystyy tarvittaessa kutsumaan Aanitiedosto-luokkaa ja asettamaan tilalle uuden Aanitiedosto-luokan.
