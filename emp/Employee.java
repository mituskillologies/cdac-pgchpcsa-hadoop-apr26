import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Job; 
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Partitioner;
import java.util.StringTokenizer;
import java.io.IOException;
public class Employee {
	public static class EmpMapper extends Mapper<Object,Text,Text,Text> {
      public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            String[] str = value.toString().split("\t");
            String gender= str[3];
            context.write(new Text(gender), new Text(value));
      }
   	} 
   	public static class EmpPartitioner extends Partitioner < Text,Text > {
      public int getPartition(Text key, Text value, int numReduceTasks) {
         String[] str = value.toString().split("\t");
         int age = Integer.parseInt(str[2]);
         if(numReduceTasks == 0)
            return 0;
       
         if(age <= 20) 
            return 0;
         else if(age > 20 && age <= 30) 
            return 1 % numReduceTasks;
         else
            return 2 % numReduceTasks;
      }
   }
   public static class EmpReducer extends Reducer
   <Text,Text,Text,IntWritable>   {
      public int max = -1;
      public void reduce(Text key, Iterable <Text> values, Context context) throws IOException, InterruptedException {
      	 max = -1;
         for (Text val : values)  {
            String [] str = val.toString().split("\t");
            if(Integer.parseInt(str[4]) > max)
            	max	= Integer.parseInt(str[4]);
         }
         context.write(new Text(key), new IntWritable(max));
      }
   }
	public static void main(String args[]) throws Exception {
		Configuration conf = new Configuration();
		Job job = new Job(conf, "Employee Records");
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);	
		job.setOutputFormatClass(TextOutputFormat.class);	
		job.setInputFormatClass(TextInputFormat.class);	
		job.setMapperClass(EmpMapper.class);	
		job.setReducerClass(EmpReducer.class);	
		
		job.setPartitionerClass(EmpPartitioner.class);
      	job.setMapOutputKeyClass(Text.class);
      	job.setMapOutputValueClass(Text.class);
		job.setNumReduceTasks(3);
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.waitForCompletion(true);
	}
}
