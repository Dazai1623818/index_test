import dev.roanh.cpqindex.Index;
import dev.roanh.cpqindex.IndexUtil;
import dev.roanh.cpqindex.ProgressListener;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        System.loadLibrary("nauty");

        Path graphPath = Path.of("graph.edge"); // replace with your actual graph
        int k = 2;
        boolean computeCores = true;
        boolean computeLabels = true;
        int threads = 2;
        int maxIntersections = -1; // unlimited

        // Using the ProgressListener to stream progress to standard output
        ProgressListener listener = ProgressListener.stream(System.out);

        // Constructing the index
        Index index = new Index(
                IndexUtil.readGraph(graphPath),
                k,
                computeCores,
                computeLabels,
                threads,
                maxIntersections,
                listener
        );

        // Calling the print method of the Index class to print index details
        index.sort();
        index.print();  // This will print the index details to standard output

        System.out.println("Index constructed!");
        System.out.println(index);
    }
}
