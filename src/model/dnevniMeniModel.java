package model;


public class dnevniMeniModel {
	
	private double cijenaDnevnogMenija;

	
	public void izracunajCijenuMenija(double procenat,double cijena)
	{
		cijenaDnevnogMenija=cijena-((procenat/100)*cijena);
	}
	
	public double getCijenaDnevnogMenija() {
		return cijenaDnevnogMenija;
	}

	public void setCijenaDnevnogMenija(double cijenaDnevnogMenija) {
		this.cijenaDnevnogMenija = cijenaDnevnogMenija;
	}
	
	
	

}
