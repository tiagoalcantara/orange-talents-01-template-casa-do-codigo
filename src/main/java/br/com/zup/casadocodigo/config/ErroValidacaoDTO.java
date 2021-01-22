package br.com.zup.casadocodigo.config;

public class ErroValidacaoDTO {
    private final String campo;
    private final String mensagem;

    public ErroValidacaoDTO(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
