package omgtu.ru;

public class Events {
    public static class OpenCatalogEvent {}
    public static class OpenProfileEvent {}
    public static class ShowDetailsEvent {
        public final String message;
        public ShowDetailsEvent(String message) {
            this.message = message;
        }
    }
}
