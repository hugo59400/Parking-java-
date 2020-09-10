package fr.dampierre;

public class Vehicule {
    private String immatriculation;
    private int nbPersonnes;

 

    public Vehicule(String imm, int nb) {
        immatriculation = imm;
       nbPersonnes = nb;
    }


    public String getImmatriculation() 
    {
        return immatriculation;
    }


}
