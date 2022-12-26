package com.univlittoral.projetback.dto;

import java.util.List;

public class HomeDTO {
	private List<LivresDTO> livres;
	private IndicateursDTO indicateurs;
	private GenresDTO genres;
	private DataGraphDTO datasGraph;

	public List<LivresDTO> getLivres() {
		return livres;
	}

	public void setLivres(List<LivresDTO> livres) {
		this.livres = livres;
	}

	public IndicateursDTO getIndicateurs() {
		return indicateurs;
	}

	public void setIndicateurs(IndicateursDTO indicateurs) {
		this.indicateurs = indicateurs;
	}

	public GenresDTO getGenres() {
		return genres;
	}

	public void setGenres(GenresDTO genres) {
		this.genres = genres;
	}

	public DataGraphDTO getDatasGraph() {
		return datasGraph;
	}

	public void setDatasGraph(DataGraphDTO datasGraph) {
		this.datasGraph = datasGraph;
	}
}
