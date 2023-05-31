package co.edu.unipiloto.patterns.payaraweb.model.solicitud;

public enum TypeSolicitud {
    RESERVAR,
    PEDIR,
    ENTREGAR,
    EXTENDER_PLAZO;

    @Override
    public String toString() {
        switch (this) {
            case RESERVAR:
                return "RESERVAR";
            case PEDIR:
                return "PEDIR";
            case ENTREGAR:
                return "ENTREGAR";
            case EXTENDER_PLAZO:
                return "EXTENDER PLAZO";
            default:
                return super.toString();
        }
    }
}
