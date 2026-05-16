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
public class Temperature {
	public static class TempMapper extends Mapper<LongWritable, Text, IntWritable, FloatWritable> { 
	public boolean flag = false;
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
    	if (flag == false) {
	    	String header =  value.toString();
	    	flag = true;
    	}
    	else {
    		String line =  value.toString();
    		String words[] = line.split(",");
    		//0->station, 1->Year, 2->Type, 3->Value
    		if (words[2].equals("TMIN")) {
    			int year = Integer.parseInt(words[1]);
    			float temp = Float.parseFloat(words[3]);
    			context.write(new IntWritable(year), new FloatWritable(temp));
    		}
    	}
    }
 }

	public static class TempReducer extends Reducer<IntWritable, FloatWritable, IntWritable, FloatWritable> {
    public void reduce(IntWritable key, Iterable<FloatWritable> values, Context context) throws IOException, InterruptedException {
        float min = 100.0f;
        for (FloatWritable val : values) {
        		float temp = val.get();
            if (temp < min) 
            	min = temp;
        }
        context.write(key, new FloatWritable(min));
    }
 }
	public static void main(String args[]) throws Exception {
		Configuration conf = new Configuration();
		Job job = new Job(conf, "Temperature");
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(FloatWritable.class);	
		job.setOutputFormatClass(TextOutputFormat.class);	
		job.setInputFormatClass(TextInputFormat.class);	
		job.setMapperClass(TempMapper.class);	
		job.setReducerClass(TempReducer.class);	
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.waitForCompletion(true);
	}
}
