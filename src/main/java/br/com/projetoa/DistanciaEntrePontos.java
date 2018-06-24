package br.com.projetoa;


public class DistanciaEntrePontos {
	
	public double calcularDistancia(double lat1, double lon1, double lat2, double lon2,
	        double el1, double el2) {

	    final int R = 6371; // Radius of the earth

	    Double latDistance = deg2rad(lat2 - lat1);
	    Double lonDistance = deg2rad(lon2 - lon1);
	    Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    double height = el1 - el2;
	    distance = Math.pow(distance, 2) + Math.pow(height, 2);
	    double distance_arred = Math.round(Math.sqrt(distance)/1000);
	    return distance_arred;
	}

	private double deg2rad(double deg) {
	    return (deg * Math.PI / 180.0);
	}

}
