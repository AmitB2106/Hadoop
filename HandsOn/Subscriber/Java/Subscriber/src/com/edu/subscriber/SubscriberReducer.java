package com.edu.Subscriber;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SubscriberReducer extends Reducer<Text,DoubleWritable,Text,DoubleWritable>{
	
	@Override
	public void reduce(Text key, Iterable<DoubleWritable> values, Context context)
			throws IOException, InterruptedException
	{
		double _TotalBytes = 0;
		
		while(values.iterator().hasNext())
		{
			_TotalBytes +=values.iterator().next().get();						
		}		
		context.write(key, new DoubleWritable(_TotalBytes));
	}
}
