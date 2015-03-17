package com.cloudbees.hudson.plugins.folder.relocate;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import hudson.model.Job;
import org.kohsuke.stapler.DataBoundConstructor;

import java.util.Collection;

/**
 * Created by valentinaarmenise on 16/03/2015.
 */
public class JobsInsideFolder extends AbstractDescribableImpl<JobsInsideFolder> {

    private final Collection<? extends Job> jobsInsideFolder;


    @DataBoundConstructor
    public JobsInsideFolder(Collection<? extends Job> jobsInsideFolder) {
        this.jobsInsideFolder = jobsInsideFolder;
    }

    public Collection<? extends Job> getJobsInsideFolder() {
        return jobsInsideFolder;
    }

    public Job getJob(String name) {
        for (Job job : jobsInsideFolder) {
            if (job.getName().equals(name)) {
                return job;
            }
        }

        return null;
    }

    @Extension
    public static final class DescriptorImpl extends Descriptor<JobsInsideFolder> {

        @Override
        public String getDisplayName() {
            return "JobsInsideFolder";
        }

    }
}