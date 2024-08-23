package com.oracledb.servcie;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class DirectoryWatcherService {
    public static void main(String[] args) throws IOException, InterruptedException {

        Path dir =
                Paths.get("watched_dir");
        // The directory you want to monitor
        WatchService watchService =
                FileSystems.getDefault().newWatchService();
        dir.register(watchService, ENTRY_CREATE, ENTRY_DELETE,
                ENTRY_MODIFY);
        System.out.println("Watching directory: " + dir);
        while (true) {
            WatchKey key = watchService.take();
            // Block until something happens
        for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                Path fileName = (Path)
                        event.context();
                if (kind == ENTRY_CREATE) {
                    System.out.println("File created: " + fileName);
                } else if (kind == ENTRY_DELETE) {
                    System.out.println("File deleted: " + fileName);
                } else if (kind == ENTRY_MODIFY) {
                    // Reset key to receive new events
                    System.out.println("File modified: " + fileName);
                }
        } boolean valid = key.reset();
           if (!valid) {
                        break;
                    }
                }


            }
        }
