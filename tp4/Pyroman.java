class Pyroman extends Thread {

  private Zone zone;
  private int debut;
  private int fin;

  public Pyroman(Zone zone, int debut, int fin) {
    this.zone = zone;
    this.debut = debut;
    this.fin = fin;
  }

  public void run() {
    do {

      try {
        //(utile uniquement après le premir tour) Tous les threads doivent avoir inspecté la condition d'arret avant que la conditon d'arrêt soit reinitialisée
        this.zone.getBarrier().await();

        if (debut == 0) this.zone.setChanged(false); //Reinitialisation de l'indicateur de changement (condition d'arret)

        //Avant de calculer la propagation, il faut être sur que la condition soit reinitilisée
        this.zone.getBarrier().await();

        //Calcul de la propagation dans la zone
        for (int i = debut; i < fin; i++) {
          for (int j = 0; j < this.zone.getCarte().length; j++) {
            this.zone.propagationCase(i, j);
          }
        }

        //Avant d'afficher, et d'échanger les cartes, il est nécessaires que tous les threads aient terminé de calculer la propagation dans leur zone
        this.zone.getBarrier().await();

        if (debut == 0) { //Premier thread, seul le premier thread affiche et échange les cartes
          this.zone.display();
          this.zone.switchCarte(); //echange de carte
        }

        Thread.sleep(1000);

      } catch (Exception e) {
        e.printStackTrace();
      }
    } while (this.zone.hasChanged()); //S'il y a eu un changement dans la carte, il faut continuer le calcul
  }
}