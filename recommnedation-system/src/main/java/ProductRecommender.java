import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

public class ProductRecommender {

    private static final Logger logger = LoggerFactory.getLogger(ProductRecommender.class);

    public static void main(String[] args) {
        try {
            // 1. Load data - use default FileDataModel constructor (does not support skipHeader)
            DataModel model = new FileDataModel(
                    new File("src/main/resources/sample_data.csv"));

            // 2. Configure similarity metric
            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);

            // 3. Define user neighborhood (3 closest users)
            UserNeighborhood neighborhood =
                    new NearestNUserNeighborhood(3, similarity, model);

            // 4. Build recommender engine
            UserBasedRecommender recommender =
                    new GenericUserBasedRecommender(model, neighborhood, similarity);

            // 5. Generate recommendations for user 2
            logger.info("Generating recommendations...");
            List<RecommendedItem> recommendations =
                    recommender.recommend(2, 3); // Top 3 items

            // 6. Display results
            System.out.println("\nTop 3 Recommendations for User 2:");
            for (RecommendedItem item : recommendations) {
                System.out.printf(
                        "Product ID: %d (Score: %.2f)%n",
                        item.getItemID(),
                        item.getValue());
            }

        } catch (Exception e) {
            logger.error("Recommendation failed", e);
            System.err.println("Error: " + e.getMessage());
        }
    }
}