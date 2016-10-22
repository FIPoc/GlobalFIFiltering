package monitor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Filter;

/**
 * Created by Rohit on 23-10-2016.
 */
public class ScheduledMonitorService {
    public void poll() throws Exception {
        ExecutorService es = Executors.newSingleThreadExecutor();

        Future legacyFuture = es.submit(new LegacyWatcher());
        Future vsFuture = es.submit(new VSWatcher());

        List<String> legacyFiles = (List<String>)legacyFuture.get();

        List<String> vsFiles = (List<String>)vsFuture.get();

        List<StagingDTO> stagingDTOList = FilterService.filer(legacyFiles, vsFiles);

        DBService.perist(stagingDTOList);

    }


}
