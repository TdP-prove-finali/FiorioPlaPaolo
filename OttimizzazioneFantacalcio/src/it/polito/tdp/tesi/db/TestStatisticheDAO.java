package it.polito.tdp.tesi.db;

public class TestStatisticheDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StatisticheDAO dao = new StatisticheDAO();
	//	System.out.println("Calciatori 2016-2017: \n");
	//	System.out.println(dao.getCalciatori20162017());
		
	//	System.out.println("Calciatori 2017-2018 \n");
	//	System.out.println(dao.getCalciatori20172018());
		
		
	//	System.out.println("Calciatori 2018-2019 \n");
	//	System.out.println(dao.getCalciatori20182019());
		
		System.out.println("Quotazioni : \n");
		System.out.println(dao.getQuotazioni());
	}

}
