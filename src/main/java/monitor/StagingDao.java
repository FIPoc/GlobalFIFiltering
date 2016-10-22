package monitor;

import common.DBServiceLocator;

import java.util.List;

/**
 * Created by Rohit on 23-10-2016.
 */
public class StagingDao extends DBServiceLocator {

    public void perist(List<StagingDTO> list) throws Exception
    {
        System.out.println("Inserting records into the table...");
        stmt = connection.createStatement();

        // Code to insert entries in staging table

    }
}
