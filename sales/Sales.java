import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.mapreduce.Job; 
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import java.util.StringTokenizer;
import java.io.IOException;
public class Sales {
	public static class SalesMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private Text month = new Text();  
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String words[] = line.split("\t");
		month.set(words[0]);
		int total = Integer.parseInt(words[6]);
		context.write(month, new IntWritable(total));
    	}
    }
    public static class SalesReducer 
            extends Reducer<Text, IntWritable, Text, IntWritable> {
        private int grandTotal = 0;
        private IntWritable result = new IntWritable();
        public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {           
            int monthTotal = 0;
            for (IntWritable val : values) {
                monthTotal += val.get();
            }
            this.grandTotal += monthTotal;    
            result.set(monthTotal);
            context.write(key, result);
        }
    	protected void cleanup(Context context) 
                throws IOException, InterruptedException {
        result.set(this.grandTotal);
        context.write(new Text("GRAND_TOTAL"), result);
    }
 }
	public static void main(String args[]) throws Exception {
		Configuration conf = new Configuration();
		Job job = new Job(conf, "Annual Sale");
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);	
		job.setOutputFormatClass(TextOutputFormat.class);	
		job.setInputFormatClass(TextInputFormat.class);	
		job.setMapperClass(SalesMapper.class);	
		job.setReducerClass(SalesReducer.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.waitForCompletion(true);
	}
}
