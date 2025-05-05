package uk.co.motors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the ApiResponse class and its nested classes.
 */
class ApiResponseTest {

    private ApiResponse apiResponse;
    private PollingInfo pollingInfo;
    private Ad ad;
    private Item item;
    private Result result;
    private Reason reason;

    // Sample data matching the structure of the original JSON
    private static final long TEST_TIMESTAMP = 1662452817080L;
    private static final boolean TEST_NEWER_ADS_EXIST = true;
    private static final String TEST_ITEM_ID = "92d0a7a1-33b1-48c5-ae36-5269e2430c3a";
    private static final String TEST_BATCH_ID = "5ecc700d-a573-4621-977f-7aba2d8d5a68";
    private static final String TEST_TASK_ID = "1ff57161-125f-4f59-b01e-3e5b060d1f64";
    private static final long TEST_PACKED_AT = 1662452817080L;
    private static final String TEST_ACTOR_ID = "me@corp.com";
    private static final String TEST_OUTCOME = "no decision";
    private static final String TEST_REASON_NAME = "No decision taken by filters.";

    @BeforeEach
    void setUp() {
        // --- Setup individual components ---

        // PollingInfo
        pollingInfo = new PollingInfo();
        pollingInfo.setNewTimestamp(TEST_TIMESTAMP);
        pollingInfo.setNewerAdsExist(TEST_NEWER_ADS_EXIST);

        // Item
        item = new Item();
        item.setId(TEST_ITEM_ID);
        item.setBatchId(TEST_BATCH_ID);
        item.setTaskId(TEST_TASK_ID);

        // Reason
        reason = new Reason();
        reason.setName(TEST_REASON_NAME);

        // Result
        result = new Result();
        result.setActorId(TEST_ACTOR_ID);
        result.setOutcome(TEST_OUTCOME);
        result.setReasons(Collections.singletonList(reason)); // Use singletonList for immutable list
        result.setFeedback(new ArrayList<>()); // Empty list as per JSON
        result.setMatchingFilters(new ArrayList<>()); // Empty list as per JSON

        // Ad
        ad = new Ad();
        ad.setItems(Collections.singletonList(item));
        ad.setPackedAt(TEST_PACKED_AT);
        ad.setResult(result);

        // ApiResponse (Top Level)
        apiResponse = new ApiResponse();
        apiResponse.setPollingInfo(pollingInfo);
        apiResponse.setAds(Collections.singletonList(ad));
    }

    @Test
    void testPollingInfoGetters() {
        assertNotNull(apiResponse.getPollingInfo(), "PollingInfo should not be null");
        assertEquals(TEST_TIMESTAMP, apiResponse.getPollingInfo().getNewTimestamp(), "Timestamp mismatch");
        assertEquals(TEST_NEWER_ADS_EXIST, apiResponse.getPollingInfo().isNewerAdsExist(), "NewerAdsExist mismatch");
    }

    @Test
    void testAdsList() {
        assertNotNull(apiResponse.getAds(), "Ads list should not be null");
        assertEquals(1, apiResponse.getAds().size(), "Ads list should contain one element");
    }

    @Test
    void testAdGetters() {
        Ad retrievedAd = apiResponse.getAds().get(0);
        assertNotNull(retrievedAd, "Ad object should not be null");
        assertEquals(TEST_PACKED_AT, retrievedAd.getPackedAt(), "PackedAt timestamp mismatch");
        assertNotNull(retrievedAd.getItems(), "Items list should not be null");
        assertNotNull(retrievedAd.getResult(), "Result object should not be null");
    }

    @Test
    void testItemsList() {
        Ad retrievedAd = apiResponse.getAds().get(0);
        List<Item> items = retrievedAd.getItems();
        assertNotNull(items, "Items list should not be null");
        assertEquals(1, items.size(), "Items list should contain one element");
    }

    @Test
    void testItemGetters() {
        Item retrievedItem = apiResponse.getAds().get(0).getItems().get(0);
        assertNotNull(retrievedItem, "Item object should not be null");
        assertEquals(TEST_ITEM_ID, retrievedItem.getId(), "Item ID mismatch");
        assertEquals(TEST_BATCH_ID, retrievedItem.getBatchId(), "Batch ID mismatch");
        assertEquals(TEST_TASK_ID, retrievedItem.getTaskId(), "Task ID mismatch");
    }

    @Test
    void testResultGetters() {
        Result retrievedResult = apiResponse.getAds().get(0).getResult();
        assertNotNull(retrievedResult, "Result object should not be null");
        assertEquals(TEST_ACTOR_ID, retrievedResult.getActorId(), "Actor ID mismatch");
        assertEquals(TEST_OUTCOME, retrievedResult.getOutcome(), "Outcome mismatch");
        assertNotNull(retrievedResult.getReasons(), "Reasons list should not be null");
        assertNotNull(retrievedResult.getFeedback(), "Feedback list should not be null");
        assertTrue(retrievedResult.getFeedback().isEmpty(), "Feedback list should be empty");
        assertNotNull(retrievedResult.getMatchingFilters(), "MatchingFilters list should not be null");
        assertTrue(retrievedResult.getMatchingFilters().isEmpty(), "MatchingFilters list should be empty");
    }

    @Test
    void testReasonsList() {
         Result retrievedResult = apiResponse.getAds().get(0).getResult();
         List<Reason> reasons = retrievedResult.getReasons();
         assertNotNull(reasons, "Reasons list should not be null");
         assertEquals(1, reasons.size(), "Reasons list should contain one element");
    }

     @Test
     void testReasonGetters() {
         Reason retrievedReason = apiResponse.getAds().get(0).getResult().getReasons().get(0);
         assertNotNull(retrievedReason, "Reason object should not be null");
         assertEquals(TEST_REASON_NAME, retrievedReason.getName(), "Reason name mismatch");
     }

     @Test
     void testToStringMethods() {
         // Basic check to ensure toString doesn't throw errors and contains some expected parts
         // More specific toString tests are often brittle and less valuable than getter/setter tests.
         assertNotNull(apiResponse.toString());
         assertTrue(apiResponse.toString().contains("PollingInfo"));
         assertTrue(apiResponse.toString().contains("Ad"));

         assertNotNull(pollingInfo.toString());
         assertTrue(pollingInfo.toString().contains(String.valueOf(TEST_TIMESTAMP)));

         assertNotNull(ad.toString());
         assertTrue(ad.toString().contains("Item"));
         assertTrue(ad.toString().contains("Result"));

         assertNotNull(item.toString());
         assertTrue(item.toString().contains(TEST_ITEM_ID));

         assertNotNull(result.toString());
         assertTrue(result.toString().contains(TEST_ACTOR_ID));
         assertTrue(result.toString().contains("Reason"));

         assertNotNull(reason.toString());
         assertTrue(reason.toString().contains(TEST_REASON_NAME));
     }
}
