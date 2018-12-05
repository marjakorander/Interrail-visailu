import java.util.Scanner;

public class Interrail {
    Maa saksa = new Maa();
    Maa ranska = new Maa();
    Maa sveitsi = new Maa();
    Maa puola = new Maa();
    Maa viro = new Maa();
    Pisteet pistemaara = new Pisteet();
    Scanner lukija = new Scanner(System.in);

    public void tulostaAloitus() {
        System.out.println("\nHuikea seikkailu on alkamassa! Olet lähdössä Interrailille halki Euroopan.");
        System.out.println("Matkalla on viisi matkakohdetta ja tarvitset vähintään neljä pistettä, jotta voit ostaa lentolipun takaisin Suomeen." +
                "\nSaat pisteen jokaisesta oikeasta vastauksesta.");
        System.out.println("Oletko valmis?");
        String vastaus = lukija.nextLine();
        vastaus.toLowerCase();
        if (vastaus.equals("joo") || vastaus.equals("Juu") || vastaus.equals("Kyllä") || vastaus.equals("juu") || vastaus.equals("kyllä") || vastaus.equals("joo") || vastaus.equals("olen") || vastaus.equals("Olen")) {
            System.out.println("___________________\nHienoa! \nSitten mennään.\n");
        } else
            System.out.println("___________________\nMennään silti!");
        odotuta();
        alustaSaksa();
    }

    public void alustaSaksa() {
        System.out.println("Suunnaksi Saksa, zum wohl!");
        saksa.setKysymys("Ensimmäinen kysymys:\nMikä on Saksan pääkaupunki?");
        saksa.setOikeaVastaus("berliini");
        System.out.println(saksa.getKysymys());
        String vastaus = lukija.nextLine().toLowerCase();
        if (vastaus.equals(saksa.getOikeaVastaus())) {
            pistemaara.setPisteet(1);
            System.out.println("Oikea vastaus! Nyt sinulla on " + pistemaara.getPisteet() + " piste.\n");
            odotutaPidempaan();
        } else {
            System.out.println("Oikea vastaus on Berliini.\nPäästäksesi joskus kotiin, sinun täytyy vastata oikein kaikkiin loppuihin kysymyksiin...\n");
            odotutaPidempaan();
        }
        alustaRanska();
    }

    public void alustaRanska() {
        System.out.println("Matka jatkuu - Ranska kutsuu...");
        odotuta();
        System.out.println("Seuraa toinen kysymys:");
        odotuta();
        ranska.setKysymys("Mikä on Ranskan kansallislaulu?");
        ranska.setOikeaVastaus("marseljeesi");
        System.out.println(ranska.getKysymys());
        String vastaus = lukija.nextLine().toLowerCase();
        if (vastaus.equals(ranska.getOikeaVastaus())) {
            pistemaara.setPisteet(pistemaara.getPisteet() + 1);
            if (pistemaara.getPisteet() == 1)
                System.out.println("Hyvin tiedetty! Sinulla on " + pistemaara.getPisteet() + " piste.\n");
            if (pistemaara.getPisteet() == 2)
                System.out.println("Hyvin tiedetty! Sinulla on " + pistemaara.getPisteet() + " pistettä.\n");
            odotutaPidempaan();
            alustaSveitsi();
        } else {
            if (pistemaara.getPisteet() == 0) {
                System.out.println("Väärin meni!\n");
                odotuta();
                tulostaLopetus();
            }
            if (pistemaara.getPisteet() == 1) {
                System.out.println("Oikea vastaus on Marseljeesi. " +
                        "\nPäästäksesi joskus kotimatkalle, sinun täytyy vastata oikein kaikkiin loppuihin kysymyksiin...\n");
                odotutaPidempaan();
                alustaSveitsi();
            }
        }
    }

    public void alustaSveitsi() {
        System.out.println("Suunnaksi Sveitsi!");
        odotuta();
        sveitsi.setKysymys("Tiedätköhän tämän: montako virallista kieltä Sveitsissä on? Kaksi vai neljä?");
        sveitsi.setOikeaVastaus("neljä");
        System.out.println(sveitsi.getKysymys());
        String vastaus = lukija.nextLine().toLowerCase();
        if (vastaus.equals(4)) {
            vastaus = "neljä";
        }
        if (vastaus.equals(sveitsi.getOikeaVastaus())) {
            pistemaara.setPisteet(pistemaara.getPisteet() + 1);
            if (pistemaara.getPisteet() == 3)
                System.out.println("Kaikki oikein tähän mennessä! Sinulla on jo " + pistemaara.getPisteet() + " pistettä.\n");
            if (pistemaara.getPisteet() == 2)
                System.out.println("Hyvin tiedetty! Sinulla on nyt " + pistemaara.getPisteet() + " pistettä.\n");
            odotutaPidempaan();
            alustaPuola();
        } else {
            if (pistemaara.getPisteet() == 2) {
                System.out.println("Väärin meni mutta matka jatkuu!\n");
                odotutaPidempaan();
                alustaPuola();
            }
            if (pistemaara.getPisteet() == 1) {
                System.out.println("Väärin meni!\n");
                odotuta();
                tulostaLopetus();
            }
        }
    }

    public void alustaPuola() {
        System.out.println("Nyt mennään Puolaan!");
        odotuta();
        puola.setKysymys("Mitäpä luulet, mikä meri huuhtoo Puolan rannikkoa?");
        puola.setOikeaVastaus("itämeri");
        System.out.println(puola.getKysymys());
        String vastaus = lukija.nextLine().toLowerCase();
        if (vastaus.equals(puola.getOikeaVastaus())) {
            pistemaara.setPisteet(pistemaara.getPisteet() + 1);
            if (pistemaara.getPisteet() == 4)
                System.out.println("Wow! Sinulla on maaliin pääsyyn vaaditut " + pistemaara.getPisteet() + " pistettä. " +
                        "Seuraavan kohteen voit sluibailla!\n");
            if (pistemaara.getPisteet() == 3)
                System.out.println("Jes! Nyt sinulla on " + pistemaara.getPisteet() + " pistettä. " +
                        "Jos tiedät vielä seuraavan, pääset maaliin...\n");
            odotutaPidempaan();
            alustaViro();
        } else {
            if (pistemaara.getPisteet() == 3) {
                System.out.println("Ei aivan. Oikea vastaus on Itämeri.\n");
                odotutaPidempaan();
                alustaViro();
            }
            if (pistemaara.getPisteet() == 2) {
                System.out.println("Väärin meni!\n");
                odotuta();
                tulostaLopetus();
            }
        }
    }

    public void alustaViro() {
        System.out.println("Matkan viimeinen etappi on Viro!");
        odotuta();
        viro.setKysymys("Kumpi mahtaa olla Viron presidentti: Kersti Kaljulaid vai Tomas Henrik Ilves?");
        viro.setOikeaVastaus("kersti kaljulaid");
        System.out.println(viro.getKysymys());
        String vastaus = lukija.nextLine().toLowerCase();
        if (vastaus.equals(viro.getOikeaVastaus())) {
            pistemaara.setPisteet(pistemaara.getPisteet() + 1);
            if (pistemaara.getPisteet() == 5)
                System.out.println("Uskomatonta! Sait matkallasi täydet " + pistemaara.getPisteet() + " pistettä. " +
                        "Paljon onnea!");
            if (pistemaara.getPisteet() == 4)
                System.out.println("Huh huh! " + pistemaara.getPisteet() + " pistettä ja matka koti-Suomeen alkaa. " +
                        "Hyvä sinä!");
            odotutaPidempaan();
            tulostaPaluu();
        } else {
            if (pistemaara.getPisteet() == 4) {
                System.out.println("Pistemääräsi on " + pistemaara.getPisteet() + ". Pääset juuri ja juuri kotimatkalle!");
                odotutaPidempaan();
                tulostaPaluu();
            }
            if (pistemaara.getPisteet() == 3) {
                System.out.println("Väärin meni!\n");
                odotuta();
                tulostaLopetus();
            }
        }
    }

    public void tulostaLopetus() {
        System.out.println("Nyt otti ohraleipä! Et pääse kotiin, koska et voi enää kerätä tarpeeksi pisteitä.\n" +
                "Joudut elelemään kerjäläisenä kaukana kotoa.");
    }

    public void tulostaPaluu() {
        System.out.println("\n" +
                "##....##..##..######..##... ##..#######.....##.....##\n" +
                "##....##..##..##......###...##..##...##....####....##\n" +
                "##....##..##..##......##.#..##..##...##...##..##...##\n" +
                "########..##..######..##..#.##..##...##..##....##..##\n" +
                "##....##..##..##......##...###..##...##..########..##\n" +
                "##....##..##..##......##....##..##...##..##....##....\n" +
                "##....##..##..######..##....##..#######..##....##..##");
    }

    public void odotuta() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.exit(0);
        }
    }

    public void odotutaPidempaan() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            System.exit(0);
        }
    }
}