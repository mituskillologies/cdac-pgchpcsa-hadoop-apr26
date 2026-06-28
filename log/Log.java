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
public class Log {
	public static class LogMapper extends Mapper<LongWritable, Text, Text, FloatWritable> {
    private Text name = new Text();  
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String words[] = line.split("\t");
        name.set(words[0]);
        int add = 0;
        for (int i = 1; i < words.length; i++) 
        	add += Integer.parseInt(words[i]);

        if (add/7.0f > 5)
        	context.write(name, new FloatWritable(add/7.0f));
    }
 }
	public static void main(String args[]) throws Exception {
		Configuration conf = new Configuration();
		Job job = new Job(conf, "Internet Log");
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(FloatWritable.class);	
		job.setOutputFormatClass(TextOutputFormat.class);	
		job.setInputFormatClass(TextInputFormat.class);	
		job.setMapperClass(LogMapper.class);	
		job.setNumReduceTasks(0);	
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.waitForCompletion(true);
	}
}
