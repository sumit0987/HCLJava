package com.demo.loanapp.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.demo.loanapp.entity.Customer;
import com.demo.loanapp.processor.CustomerProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	JobBuilderFactory jobBuilderFactory;

	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public LineMapper<Customer> lineMapper() {
		DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<Customer>();
		lineMapper.setLineTokenizer(new DelimitedLineTokenizer() {
			{
				setNames(new String[] { "userid", "name", "gender", "age","panno","aadharno","salary" });
			}
		});
		lineMapper.setFieldSetMapper(new BeanWrapperFieldSetMapper<Customer>() {
			{
				setTargetType(Customer.class);
			}
		});
		return lineMapper;
	}
	
	@Bean
	public FlatFileItemReader<Customer> reader() {
	    return new FlatFileItemReaderBuilder<Customer>()
		  .name("customerItemReader")		
		  .resource(new ClassPathResource("customer.csv"))
		  .lineMapper(lineMapper())
		  .linesToSkip(1)
		  .build(); 
	}
	
	@Bean
	public Job createCustomerJob(Step step1) {
	    return jobBuilderFactory
		  .get("createCustomerJob")
		  .incrementer(new RunIdIncrementer())
		  .start(step1)
		  .build();
	}

	@Bean
	public Step step(FlatFileItemReader<Customer> reader,CustomerProcessor processor, ItemWriter<Customer> itemWriter) {
	    return stepBuilderFactory
		  .get("step1")
		  .<Customer, Customer>chunk(2)
		  .reader(reader)
		  .processor(processor)
		  .writer(itemWriter)
		  .build();
	}
	
	
}
