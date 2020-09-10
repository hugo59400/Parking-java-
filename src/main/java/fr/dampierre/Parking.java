package fr.dampierre;

import java.util.ArrayList;
import java.util.List;

public class Parking {

  private int capacite;
  private List<Vehicule> vehiculesPresents = new ArrayList<>();

  public Parking(int capacite) {
    this.capacite = capacite;
  }

  int getNbVehiculesPresents() {
    return vehiculesPresents.size();
  }

  boolean enregistrerEntree(String immatriculation, int nbPersonnes) {
    if (!estPlein() && !estPresente(immatriculation)) {
      Vehicule v= new Vehicule(immatriculation, nbPersonnes);
      vehiculesPresents.add(v);
     
      return true;
    }
    return false;
  }

  boolean estPresente(String immatriculation) {
    for (Vehicule vehicule : vehiculesPresents) {
      if (vehicule.getImmatriculation().equals(immatriculation)) {
        return true;
      }
    }
    return false;
  }

  boolean enregistrerSortie(String immatriculation) {
    for (Vehicule vehicule : vehiculesPresents) {
      if (vehicule.getImmatriculation().equals(immatriculation)) {
        vehiculesPresents.remove(vehicule);
        return true;
      }
    }
    return false;
  }

  private boolean estPlein() {
    return vehiculesPresents.size() >= capacite;
  }

  boolean estVide() {
    return vehiculesPresents.isEmpty();
  }

  void afficherImmatriculationsPresentes() {
    for (Vehicule v : vehiculesPresents) {
      System.out.println(v.getImmatriculation());
    }
  }

  public double tauxDOccupation() {
    return (double) vehiculesPresents.size() / capacite * 100.0;
  }

  public int getCapacite() {
    return capacite;
  }
}
