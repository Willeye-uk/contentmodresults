package uk.co.motors;

import java.util.List;

// Main class representing the root JSON object
public class ApiResponse {
    private PollingInfo pollingInfo;
    private List<Ad> ads;

    // Getters and Setters
    public PollingInfo getPollingInfo() {
        return pollingInfo;
    }

    public void setPollingInfo(PollingInfo pollingInfo) {
        this.pollingInfo = pollingInfo;
    }

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
               "pollingInfo=" + pollingInfo +
               ", ads=" + ads +
               '}';
    }
}

// Class representing the 'pollingInfo' object
class PollingInfo {
    private long newTimestamp;
    private boolean newerAdsExist;

    // Getters and Setters
    public long getNewTimestamp() {
        return newTimestamp;
    }

    public void setNewTimestamp(long newTimestamp) {
        this.newTimestamp = newTimestamp;
    }

    public boolean isNewerAdsExist() {
        return newerAdsExist;
    }

    public void setNewerAdsExist(boolean newerAdsExist) {
        this.newerAdsExist = newerAdsExist;
    }

     @Override
     public String toString() {
         return "PollingInfo{" +
                "newTimestamp=" + newTimestamp +
                ", newerAdsExist=" + newerAdsExist +
                '}';
     }
}

// Class representing an object within the 'ads' array
class Ad {
    private List<Item> items;
    private long packedAt;
    private Result result;

    // Getters and Setters
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public long getPackedAt() {
        return packedAt;
    }

    public void setPackedAt(long packedAt) {
        this.packedAt = packedAt;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Ad{" +
               "items=" + items +
               ", packedAt=" + packedAt +
               ", result=" + result +
               '}';
    }
}

// Class representing an object within the 'items' array
class Item {
    private String id;
    private String batchId;
    private String taskId;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "Item{" +
               "id='" + id + '\'' +
               ", batchId='" + batchId + '\'' +
               ", taskId='" + taskId + '\'' +
               '}';
    }
}

// Class representing the 'result' object
class Result {
    private String actorId;
    private String outcome;
    private List<Reason> reasons;
    private List<Object> feedback; // Using Object as the type isn't specified
    private List<Object> matchingFilters; // Using Object as the type isn't specified

    // Getters and Setters
    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public List<Reason> getReasons() {
        return reasons;
    }

    public void setReasons(List<Reason> reasons) {
        this.reasons = reasons;
    }

    public List<Object> getFeedback() {
        return feedback;
    }

    public void setFeedback(List<Object> feedback) {
        this.feedback = feedback;
    }

    public List<Object> getMatchingFilters() {
        return matchingFilters;
    }

    public void setMatchingFilters(List<Object> matchingFilters) {
        this.matchingFilters = matchingFilters;
    }

    @Override
    public String toString() {
        return "Result{" +
               "actorId='" + actorId + '\'' +
               ", outcome='" + outcome + '\'' +
               ", reasons=" + reasons +
               ", feedback=" + feedback +
               ", matchingFilters=" + matchingFilters +
               '}';
    }
}

// Class representing an object within the 'reasons' array
class Reason {
    private String name;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

     @Override
     public String toString() {
         return "Reason{" +
                "name='" + name + '\'' +
                '}';
     }
}