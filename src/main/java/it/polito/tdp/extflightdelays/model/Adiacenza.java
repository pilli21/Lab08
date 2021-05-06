package it.polito.tdp.extflightdelays.model;

public class Adiacenza {

	private Integer id1;
	private Integer id2;
	private Integer sommaMiglia;
	private Integer numeroVoli;
		
	public Adiacenza(Integer id1, Integer id2, Integer sommaMiglia, Integer numeroVoli) {
		this.id1 = id1;
		this.id2 = id2;
		this.sommaMiglia = sommaMiglia;
		this.numeroVoli = numeroVoli;
	}
	
	public Integer getId1() {
		return id1;
	}
	public void setId1(Integer id1) {
		this.id1 = id1;
	}
	public Integer getId2() {
		return id2;
	}
	public void setId2(Integer id2) {
		this.id2 = id2;
	}
	public Integer getSommaMiglia() {
		return sommaMiglia;
	}
	public void setSommaMiglia(Integer sommaMiglia) {
		this.sommaMiglia = sommaMiglia;
	}
	public Integer getNumeroVoli() {
		return numeroVoli;
	}
	public void setNumeroVoli(Integer numeroVoli) {
		this.numeroVoli = numeroVoli;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id1 == null) ? 0 : id1.hashCode());
		result = prime * result + ((id2 == null) ? 0 : id2.hashCode());
		result = prime * result + ((numeroVoli == null) ? 0 : numeroVoli.hashCode());
		result = prime * result + ((sommaMiglia == null) ? 0 : sommaMiglia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adiacenza other = (Adiacenza) obj;
		if (id1 == null) {
			if (other.id1 != null)
				return false;
		} else if (!id1.equals(other.id1))
			return false;
		if (id2 == null) {
			if (other.id2 != null)
				return false;
		} else if (!id2.equals(other.id2))
			return false;
		if (numeroVoli == null) {
			if (other.numeroVoli != null)
				return false;
		} else if (!numeroVoli.equals(other.numeroVoli))
			return false;
		if (sommaMiglia == null) {
			if (other.sommaMiglia != null)
				return false;
		} else if (!sommaMiglia.equals(other.sommaMiglia))
			return false;
		return true;
	}
	
	
	
}
