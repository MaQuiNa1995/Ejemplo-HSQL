package maquina1995.hibernate.dto;

public class NinjaNinjutsuDto {

	private String nombreNinja;
	private String nombreNinjutsu;

	public NinjaNinjutsuDto() {

	}

	public NinjaNinjutsuDto(String nombreNinja, String nombreNinjutsu) {
		super();
		this.nombreNinja = nombreNinja;
		this.nombreNinjutsu = nombreNinjutsu;
	}

	public String getNombreNinja() {
		return nombreNinja;
	}

	public void setNombreNinja(String nombreNinja) {
		this.nombreNinja = nombreNinja;
	}

	public String getNombreNinjutsu() {
		return nombreNinjutsu;
	}

	public void setNombreNinjutsu(String nombreNinjutsu) {
		this.nombreNinjutsu = nombreNinjutsu;
	}

}
