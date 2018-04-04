package nobelsProject;

public class Laureates {
	private Long id;
	private String firstname;
	private String lastname;
	private String motivation;
	private int shareOfPrize;
	private int year;
	private String category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMotivation() {
		return motivation;
	}

	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}

	public int getShareOfPrize() {
		return shareOfPrize;
	}

	public void setShareOfPrize(int shareOfPrize) {
		this.shareOfPrize = shareOfPrize;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Laureates) {
			if (((Laureates) obj).id == this.id) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		return String.format(
				"[Laureate:{id:%d,firstname:%s,lastname:%s,motivation:%s," + "shareOfPrize:%d,year:%d,category:%s}",
				this.id, this.firstname, this.lastname, this.motivation, this.shareOfPrize, this.year, this.category);
	}

}
