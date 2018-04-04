# nobelsSpringRestService
A starter spring rest interface project

The project is based on Spring REST.

Maven is used to add jars required for spring restful service.

A sample dataset of nobel prize winners from mysql database and created the service.

<p>In dao.properties file inside src/main/resources, provide database name and credentials.</p>

Nobels data can be downloaded from this link: <a href="https://github.com/venkatsgithub1/nobels_mysql_dump">Nobels database dump</a>

<p>Import maven project in eclipse, provide database details in dao.properties and run mvn clean install.</p>
<p>Although target is already provided, mvn command can be run.</p>

<p>The project only implemented all nobel prize winners endpoint /nobelPrizeWinners, you may add functionality in spring controller java file for these methods in NobelsDAO.</p>
  
`
  public List<Laureates> getWinnersByYear(int year);

	public List<Laureates> getWinners();

	public List<Laureates> getWinnerByName(String name);

	public List<Laureates> getWinnersByCategory(String category);
`

<p>Run service on host:8080/&lt;end-point in controller java file&gt;</p>
