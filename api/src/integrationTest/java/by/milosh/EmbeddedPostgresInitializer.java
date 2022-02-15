package by.milosh;

import lombok.SneakyThrows;
import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextClosedEvent;

import java.io.IOException;

public class EmbeddedPostgresInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final int DB_PORT = 5679;

    private EmbeddedPostgres postgres;

    @Override
    @SneakyThrows
    public void initialize(ConfigurableApplicationContext context) {
        startPostgres();

        context.addApplicationListener(this::stopOnContextClosed);
    }

    private void startPostgres() throws IOException {
        postgres = EmbeddedPostgres.builder()
            .setPort(DB_PORT)
            .start();
    }

    private void stopPostgres() throws IOException {
        postgres.close();
    }

    @SneakyThrows
    private void stopOnContextClosed(ApplicationEvent event) {
        if (event instanceof ContextClosedEvent) {
            stopPostgres();
        }
    }
}
