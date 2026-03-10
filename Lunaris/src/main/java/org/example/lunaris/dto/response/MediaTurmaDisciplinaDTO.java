package org.example.lunaris.dto.response;

import java.util.List;

public class MediaTurmaDisciplinaDTO {
    String turmaNome;
    List<MediaDisciplinaDTO> mediaDisciplinaDTOS;

    public MediaTurmaDisciplinaDTO() {
    }
    public MediaTurmaDisciplinaDTO(String turmaNome, List<MediaDisciplinaDTO> mediaDisciplinaDTOS) {
        this.turmaNome = turmaNome;
        this.mediaDisciplinaDTOS = mediaDisciplinaDTOS;
    }

    public String getTurmaNome() {
        return turmaNome;
    }

    public void setTurmaNome(String turmaNome) {
        this.turmaNome = turmaNome;
    }

    public List<MediaDisciplinaDTO> getMediaDisciplinaDTOS() {
        return mediaDisciplinaDTOS;
    }

    public void setMediaDisciplinaDTOS(List<MediaDisciplinaDTO> mediaDisciplinaDTOS) {
        this.mediaDisciplinaDTOS = mediaDisciplinaDTOS;
    }
}
