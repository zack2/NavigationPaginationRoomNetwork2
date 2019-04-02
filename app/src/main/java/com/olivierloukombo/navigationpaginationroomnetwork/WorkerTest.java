package com.olivierloukombo.navigationpaginationroomnetwork;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class WorkerTest extends Worker {
    private static final String TAG = WorkerTest.class.getSimpleName();
    private Context mContext;
    public WorkerTest(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        mContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {

        // Ajouter du code dans les prochaines mise à jour
        return Result.success();
    }

}
