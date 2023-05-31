package co.edu.unipiloto.patterns.payaraweb.model.socio;

public enum TypeSocio {
    DEFAULT,
    SOCIO,
    SOCIOVIP;

    @Override
    public String toString() {
        switch (this) {
            case DEFAULT:
                return "DEFAULT";
            case SOCIO:
                return "SOCIO";
            case SOCIOVIP:
                return "SOCIOVIP";
            default:
                return super.toString();
        }
    }
}
