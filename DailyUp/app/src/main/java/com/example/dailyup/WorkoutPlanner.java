package com.example.dailyup;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkoutPlanner extends AppCompatActivity {
    Map<String, List<String>> map = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner);
        process();

        final TextView minute = findViewById(R.id.et_minute);
        final TextView muscle1 = findViewById(R.id.et_muscle1);
        final TextView muscle2 = findViewById(R.id.et_muscle2);
        final TextView muscle3 = findViewById(R.id.et_muscle3);
        final TextView textView = findViewById(R.id.text_notifications);

        final Button start = findViewById(R.id.button_start_exercise);
        start.setOnClickListener(view -> {

            String muscle1Text = muscle1.getText().toString();
            String muscle2Text = muscle2.getText().toString();
            String muscle3Text = muscle3.getText().toString();
            String minuteText = minute.getText().toString();

            String desc = "";
            if(minuteText == null || "".equals(minuteText.trim())){
                desc = "Please input minute";
            }else {
                String action1 = getRandomAction(muscle1Text);
                String action2 = getRandomAction(muscle2Text);
                String action3 = getRandomAction(muscle3Text);

                int muscleSize = 0; // 计算用户选了几项
                if(action1 != null) muscleSize ++;
                if(action2 != null) muscleSize ++;
                if(action3 != null) muscleSize ++;


                if(muscleSize == 0){
                    desc = "We can't return the result you are looking for";
                }else{
                    int cost = Integer.parseInt(minuteText)/muscleSize;
                    if(action1 != null) desc += action1 +":"+cost+" min \n";
                    if(action2 != null) desc += action2 +":"+cost+" min \n";
                    if(action3 != null) desc += action3 +":"+cost+" min \n";
                }
            }

            textView.setText(desc);

            // reset input
            minute.setText("");
            muscle1.setText("");
            muscle2.setText("");
            muscle3.setText("");
        });
    }

    private String getRandomAction(String muscle){
        List<String> actions = map.get(muscle);
        if(actions == null){
            return null;
        }
        Collections.shuffle(actions);
        return actions.get(0);
    }

    // 解析数据
    private void process(){
        String[] split = db.split("\n");
        for (String line : split) {
            String[] segment = line.split(",");
            if(segment.length != 2) continue;

            String muscle = segment[1].trim();
            String action = segment[0];
            List<String> actions = map.get(muscle);
            if(actions == null){
                actions = new ArrayList<>();
                map.put(muscle,actions);
            }

            actions.add(action);
        }
    }

    private String db = "ab crunch machine, abdominals\n" +
            "ab roller, abdominals\n" +
            "adductor, adductors\n" +
            "adductor/groin, adductors\n" +
            "advanced kettlebell windmill, abdominals\n" +
            "air bike, abdominals\n" +
            "all fours quad stretch, quadriceps\n" +
            "alternate hammer curl, biceps\n" +
            "alternate heel touchers, abdominals\n" +
            "alternate incline dumbbell curl, biceps\n" +
            "alternate leg diagonal bound, quadriceps\n" +
            "alternating cable shoulder press, shoulders\n" +
            "alternating deltoid raise, shoulders\n" +
            "alternating floor press, chest\n" +
            "alternating hang clean, hamstrings\n" +
            "alternating kettlebell press, shoulders\n" +
            "alternating kettlebell row, middle back\n" +
            "alternating renegade row, middle back\n" +
            "ankle circles, calves\n" +
            "ankle on the knee, glutes\n" +
            "anterior tibialis-smr, calves\n" +
            "anti-gravity press, shoulders\n" +
            "arm circles, shoulders\n" +
            "arnold dumbbell press, shoulders\n" +
            "around the worlds, chest\n" +
            "atlas stone trainer, lower back\n" +
            "atlas stones, lower back\n" +
            "axle deadlift, lower back\n" +
            "ab crunch machine, abdominals\n" +
            "ab roller, abdominals\n" +
            "adductor, adductors\n" +
            "adductor/groin, adductors\n" +
            "advanced kettlebell windmill, abdominals\n" +
            "air bike, abdominals\n" +
            "all fours quad stretch, quadriceps\n" +
            "alternate hammer curl, biceps\n" +
            "alternate heel touchers, abdominals\n" +
            "alternate incline dumbbell curl, biceps\n" +
            "alternate leg diagonal bound, quadriceps\n" +
            "alternating cable shoulder press, shoulders\n" +
            "alternating deltoid raise, shoulders\n" +
            "alternating floor press, chest\n" +
            "alternating hang clean, hamstrings\n" +
            "alternating kettlebell press, shoulders\n" +
            "alternating kettlebell row, middle back\n" +
            "alternating renegade row, middle back\n" +
            "ankle circles, calves\n" +
            "ankle on the knee, glutes\n" +
            "anterior tibialis-smr, calves\n" +
            "anti-gravity press, shoulders\n" +
            "arm circles, shoulders\n" +
            "arnold dumbbell press, shoulders\n" +
            "around the worlds, chest\n" +
            "atlas stone trainer, lower back\n" +
            "atlas stones, lower back\n" +
            "axle deadlift, lower back\n" +
            "back flyes - with bands, shoulders\n" +
            "backward drag, quadriceps\n" +
            "backward medicine ball throw, shoulders\n" +
            "balance board, calves\n" +
            "ball leg curl, hamstrings\n" +
            "band assisted pull-up, lats\n" +
            "band good morning, hamstrings\n" +
            "band good morning (pull through), hamstrings\n" +
            "band hip adductions, adductors\n" +
            "band pull apart, shoulders\n" +
            "band skull crusher, triceps\n" +
            "barbell ab rollout, abdominals\n" +
            "barbell ab rollout - on knees, abdominals\n" +
            "barbell bench press - medium grip, chest\n" +
            "barbell curl, biceps\n" +
            "barbell curls lying against an incline, biceps\n" +
            "barbell deadlift, lower back\n" +
            "barbell full squat, quadriceps\n" +
            "barbell glute bridge, glutes\n" +
            "barbell guillotine bench press, chest\n" +
            "barbell hack squat, quadriceps\n" +
            "barbell hip thrust, glutes\n" +
            "barbell incline bench press - medium grip, chest\n" +
            "barbell incline shoulder raise, shoulders\n" +
            "barbell lunge, quadriceps\n" +
            "barbell rear delt row, shoulders\n" +
            "barbell rollout from bench, abdominals\n" +
            "barbell seated calf raise, calves\n" +
            "barbell shoulder press, shoulders\n" +
            "barbell shrug, traps\n" +
            "barbell shrug behind the back, traps\n" +
            "barbell side bend, abdominals\n" +
            "barbell side split squat, quadriceps\n" +
            "barbell squat, quadriceps\n" +
            "barbell squat to a bench, quadriceps\n" +
            "barbell step ups, quadriceps\n" +
            "barbell walking lunge, quadriceps\n" +
            "battling ropes, shoulders\n" +
            "bear crawl sled drags, quadriceps\n" +
            "behind head chest stretch, chest\n" +
            "bench dips, triceps\n" +
            "bench jump, quadriceps\n" +
            "bench press - powerlifting, triceps\n" +
            "bench press - with bands, chest\n" +
            "bench press with chains, triceps\n" +
            "bench sprint, quadriceps\n" +
            "bent over barbell row, middle back\n" +
            "bent over dumbbell rear delt raise with head on bench, shoulders\n" +
            "bent over low-pulley side lateral, shoulders\n" +
            "bent over one-arm long bar row, middle back\n" +
            "bent over two-arm long bar row, middle back\n" +
            "bent over two-dumbbell row, middle back\n" +
            "bent over two-dumbbell row with palms in, middle back\n" +
            "bent press, abdominals\n" +
            "bent-arm barbell pullover, lats\n" +
            "bent-arm dumbbell pullover, chest\n" +
            "bent-knee hip raise, abdominals\n" +
            "bicycling, quadriceps\n" +
            "bicycling, stationary, quadriceps\n" +
            "board press, triceps\n" +
            "body tricep press, triceps\n" +
            "body-up, triceps\n" +
            "bodyweight flyes, chest\n" +
            "bodyweight mid row, middle back\n" +
            "bodyweight squat, quadriceps\n" +
            "bodyweight walking lunge, quadriceps\n" +
            "bosu ball cable crunch with side bends, abdominals\n" +
            "bottoms up, abdominals\n" +
            "bottoms-up clean from the hang position, forearms\n" +
            "box jump (multiple response), hamstrings\n" +
            "box skip, hamstrings\n" +
            "box squat, quadriceps\n" +
            "box squat with bands, quadriceps\n" +
            "box squat with chains, quadriceps\n" +
            "brachialis-smr, biceps\n" +
            "bradford/rocky presses, shoulders\n" +
            "butt lift (bridge), glutes\n" +
            "butt-ups, abdominals\n" +
            "butterfly, chest\n" +
            "cable chest press, chest\n" +
            "cable crossover, chest\n" +
            "cable crunch, abdominals\n" +
            "cable deadlifts, quadriceps\n" +
            "cable hammer curls - rope attachment, biceps\n" +
            "cable hip adduction, quadriceps\n" +
            "cable incline pushdown, lats\n" +
            "cable incline triceps extension, triceps\n" +
            "cable internal rotation, shoulders\n" +
            "cable iron cross, chest\n" +
            "cable judo flip, abdominals\n" +
            "cable lying triceps extension, triceps\n" +
            "cable one arm tricep extension, triceps\n" +
            "cable preacher curl, biceps\n" +
            "cable rear delt fly, shoulders\n" +
            "cable reverse crunch, abdominals\n" +
            "cable rope overhead triceps extension, triceps\n" +
            "cable rope rear-delt rows, shoulders\n" +
            "cable russian twists, abdominals\n" +
            "cable seated crunch, abdominals\n" +
            "cable seated lateral raise, shoulders\n" +
            "cable shoulder press, shoulders\n" +
            "cable shrugs, traps\n" +
            "cable tuck reverse crunch, abdominals\n" +
            "cable wrist curl, forearms\n" +
            "calf press, calves\n" +
            "calf press on the leg press machine, calves\n" +
            "calf raise on a dumbbell, calves\n" +
            "calf raises - with bands, calves\n" +
            "calf stretch elbows against wall, calves\n" +
            "calf stretch hands against wall, calves\n" +
            "calf-machine shoulder shrug, traps\n" +
            "calves-smr, calves\n" +
            "car deadlift, quadriceps\n" +
            "car drivers, shoulders\n" +
            "carioca quick step, adductors\n" +
            "cat stretch, lower back\n" +
            "catch and overhead throw, lats\n" +
            "chain handle extension, triceps\n" +
            "chain press, chest\n" +
            "chair leg extended stretch, hamstrings\n" +
            "chair lower back stretch, lats\n" +
            "chair squat, quadriceps\n" +
            "chair upper body stretch, shoulders\n" +
            "chest and front of shoulder stretch, chest\n" +
            "chest push (multiple response), chest\n" +
            "chest push (single response), chest\n" +
            "chest push from 3 point stance, chest\n" +
            "chest push with run release, chest\n" +
            "chest stretch on stability ball, chest\n" +
            "child's pose, lower back\n" +
            "chin to chest stretch, neck\n" +
            "chin-up, lats\n" +
            "circus bell, shoulders\n" +
            "clean, hamstrings\n" +
            "clean and jerk, shoulders\n" +
            "clean and press, shoulders\n" +
            "clean deadlift, hamstrings\n" +
            "clean from blocks, quadriceps\n" +
            "clean pull, quadriceps\n" +
            "clean shrug, traps\n" +
            "clock push-up, chest\n" +
            "close-grip barbell bench press, triceps\n" +
            "close-grip dumbbell press, triceps\n" +
            "close-grip ez bar curl, biceps\n" +
            "close-grip ez-bar curl with band, biceps\n" +
            "close-grip ez-bar press, triceps\n" +
            "close-grip front lat pulldown, lats\n" +
            "close-grip push-up off of a dumbbell, triceps\n" +
            "close-grip standing barbell curl, biceps\n" +
            "cocoons, abdominals\n" +
            "conan's wheel, quadriceps\n" +
            "concentration curls, biceps\n" +
            "cross body hammer curl, biceps\n" +
            "cross over - with bands, chest\n" +
            "cross-body crunch, abdominals\n" +
            "crossover reverse lunge, lower back\n" +
            "crucifix, shoulders\n" +
            "crunch - hands overhead, abdominals\n" +
            "crunch - legs on exercise ball, abdominals\n" +
            "crunches, abdominals\n" +
            "cuban press, shoulders\n" +
            "dancer's stretch, lower back\n" +
            "deadlift with bands, lower back\n" +
            "deadlift with chains, lower back\n" +
            "decline barbell bench press, chest\n" +
            "decline close-grip bench to skull crusher, triceps\n" +
            "decline crunch, abdominals\n" +
            "decline dumbbell bench press, chest\n" +
            "decline dumbbell flyes, chest\n" +
            "decline dumbbell triceps extension, triceps\n" +
            "decline ez bar triceps extension, triceps\n" +
            "decline oblique crunch, abdominals\n" +
            "decline push-up, chest\n" +
            "decline reverse crunch, abdominals\n" +
            "decline smith press, chest\n" +
            "deficit deadlift, lower back\n" +
            "depth jump leap, quadriceps\n" +
            "dip machine, triceps\n" +
            "dips - chest version, chest\n" +
            "dips - triceps version, triceps\n" +
            "donkey calf raises, calves\n" +
            "double kettlebell alternating hang clean, hamstrings\n" +
            "double kettlebell jerk, shoulders\n" +
            "double kettlebell push press, shoulders\n" +
            "double kettlebell snatch, shoulders\n" +
            "double kettlebell windmill, abdominals\n" +
            "double leg butt kick, quadriceps\n" +
            "downward facing balance, glutes\n" +
            "drag curl, biceps\n" +
            "drop push, chest\n" +
            "dumbbell alternate bicep curl, biceps\n" +
            "dumbbell bench press, chest\n" +
            "dumbbell bench press with neutral grip, chest\n" +
            "dumbbell bicep curl, biceps\n" +
            "dumbbell clean, hamstrings\n" +
            "dumbbell floor press, triceps\n" +
            "dumbbell flyes, chest\n" +
            "dumbbell incline row, middle back\n" +
            "dumbbell incline shoulder raise, shoulders\n" +
            "dumbbell lunges, quadriceps\n" +
            "dumbbell lying one-arm rear lateral raise, shoulders\n" +
            "dumbbell lying pronation, forearms\n" +
            "dumbbell lying rear lateral raise, shoulders\n" +
            "dumbbell lying supination, forearms\n" +
            "dumbbell one-arm shoulder press, shoulders\n" +
            "dumbbell one-arm triceps extension, triceps\n" +
            "dumbbell one-arm upright row, shoulders\n" +
            "dumbbell prone incline curl, biceps\n" +
            "dumbbell raise, shoulders\n" +
            "dumbbell rear lunge, quadriceps\n" +
            "dumbbell scaption, shoulders\n" +
            "dumbbell seated box jump, quadriceps\n" +
            "dumbbell seated one-leg calf raise, calves\n" +
            "dumbbell shoulder press, shoulders\n" +
            "dumbbell shrug, traps\n" +
            "dumbbell side bend, abdominals\n" +
            "dumbbell squat, quadriceps\n" +
            "dumbbell squat to a bench, quadriceps\n" +
            "dumbbell step ups, quadriceps\n" +
            "dumbbell tricep extension -pronated grip, triceps\n" +
            "dynamic back stretch, lats\n" +
            "dynamic chest stretch, chest\n" +
            "elbow circles, shoulders\n" +
            "elbow to knee, abdominals\n" +
            "elbows back, chest\n" +
            "elevated back lunge, quadriceps\n" +
            "elevated cable rows, lats\n" +
            "elliptical trainer, quadriceps\n" +
            "exercise ball crunch, abdominals\n" +
            "exercise ball pull-in, abdominals\n" +
            "extended range one-arm kettlebell floor press, chest\n" +
            "external rotation, shoulders\n" +
            "external rotation with band, shoulders\n" +
            "external rotation with cable, shoulders\n" +
            "ez-bar curl, biceps\n" +
            "ez-bar skullcrusher, triceps\n" +
            "face pull, shoulders\n" +
            "farmer's walk, forearms\n" +
            "fast skipping, quadriceps\n" +
            "finger curls, forearms\n" +
            "flat bench cable flyes, chest\n" +
            "flat bench leg pull-in, abdominals\n" +
            "flat bench lying leg raise, abdominals\n" +
            "flexor incline dumbbell curls, biceps\n" +
            "floor glute-ham raise, hamstrings\n" +
            "floor press, triceps\n" +
            "floor press with chains, triceps\n" +
            "flutter kicks, glutes\n" +
            "foot-smr, calves\n" +
            "forward drag with press, chest\n" +
            "frankenstein squat, quadriceps\n" +
            "freehand jump squat, quadriceps\n" +
            "frog hops, quadriceps\n" +
            "frog sit-ups, abdominals\n" +
            "front barbell squat, quadriceps\n" +
            "front barbell squat to a bench, quadriceps\n" +
            "front box jump, hamstrings\n" +
            "front cable raise, shoulders\n" +
            "front cone hops (or hurdle hops), quadriceps\n" +
            "front dumbbell raise, shoulders\n" +
            "front incline dumbbell raise, shoulders\n" +
            "front leg raises, hamstrings\n" +
            "front plate raise, shoulders\n" +
            "front raise and pullover, chest\n" +
            "front squat (clean grip), quadriceps\n" +
            "front squats with two kettlebells, quadriceps\n" +
            "front two-dumbbell raise, shoulders\n" +
            "full range-of-motion lat pulldown, lats\n" +
            "gironda sternum chins, lats\n" +
            "glute ham raise, hamstrings\n" +
            "glute kickback, glutes\n" +
            "goblet squat, quadriceps\n" +
            "good morning, hamstrings\n" +
            "good morning off pins, hamstrings\n" +
            "gorilla chin/crunch, abdominals\n" +
            "groin and back stretch, adductors\n" +
            "groiners, adductors\n" +
            "hack squat, quadriceps\n" +
            "hammer curls, biceps\n" +
            "hammer grip incline db bench press, chest\n" +
            "hamstring stretch, hamstrings\n" +
            "hamstring-smr, hamstrings\n" +
            "handstand push-ups, shoulders\n" +
            "hang clean, quadriceps\n" +
            "hang clean - below the knees, quadriceps\n" +
            "hang snatch, hamstrings\n" +
            "hang snatch - below knees, hamstrings\n" +
            "hanging bar good morning, hamstrings\n" +
            "hanging leg raise, abdominals\n" +
            "hanging pike, abdominals\n" +
            "heaving snatch balance, quadriceps\n" +
            "heavy bag thrust, chest\n" +
            "high cable curls, biceps\n" +
            "hip circles (prone), abductors\n" +
            "hip crossover,\n" +
            "hip extension with bands, glutes\n" +
            "hip flexion with band, quadriceps\n" +
            "hip lift with band, glutes\n" +
            "hug a ball, lower back\n" +
            "hug knees to chest, lower back\n" +
            "hurdle hops, hamstrings\n" +
            "hyperextensions (back extensions), lower back\n" +
            "hyperextensions with no hyperextension bench, lower back\n" +
            "iliotibial tract-smr, abductors\n" +
            "incline barbell triceps extension, triceps\n" +
            "incline bench pull, middle back\n" +
            "incline cable chest press, chest\n" +
            "incline cable flye, chest\n" +
            "incline dumbbell bench with palms facing in, chest\n" +
            "incline dumbbell curl, biceps\n" +
            "incline dumbbell flyes, chest\n" +
            "incline dumbbell flyes - with a twist, chest\n" +
            "incline dumbbell press, chest\n" +
            "incline hammer curls, biceps\n" +
            "incline inner biceps curl, biceps\n" +
            "incline push-up, chest\n" +
            "incline push-up close-grip, triceps\n" +
            "incline push-up depth jump, chest\n" +
            "incline push-up medium, chest\n" +
            "incline push-up reverse grip, chest\n" +
            "incline push-up wide, chest\n" +
            "intermediate groin stretch, hamstrings\n" +
            "intermediate hip flexor and quad stretch, quadriceps\n" +
            "internal rotation with band, shoulders\n" +
            "inverted row, middle back\n" +
            "inverted row with straps, middle back\n" +
            "iron cross, shoulders\n" +
            "iron crosses (stretch), quadriceps\n" +
            "isometric chest squeezes, chest\n" +
            "isometric neck exercise - front and back, neck\n" +
            "isometric neck exercise - sides, neck\n" +
            "isometric wipers, chest\n" +
            "it band and glute stretch, abductors\n" +
            "jackknife sit-up, abdominals\n" +
            "janda sit-up, abdominals\n" +
            "jefferson squats, quadriceps\n" +
            "jerk balance, shoulders\n" +
            "jerk dip squat, quadriceps\n" +
            "jm press, triceps\n" +
            "jogging-treadmill, quadriceps\n" +
            "keg load, lower back\n" +
            "kettlebell arnold press, shoulders\n" +
            "kettlebell dead clean, hamstrings\n" +
            "kettlebell figure 8, abdominals\n" +
            "kettlebell hang clean, hamstrings\n" +
            "kettlebell one-legged deadlift, hamstrings\n" +
            "kettlebell pass between the legs, abdominals\n" +
            "kettlebell pirate ships, shoulders\n" +
            "kettlebell pistol squat, quadriceps\n" +
            "kettlebell seated press, shoulders\n" +
            "kettlebell seesaw press, shoulders\n" +
            "kettlebell sumo high pull, traps\n" +
            "kettlebell thruster, shoulders\n" +
            "kettlebell turkish get-up (lunge style), shoulders\n" +
            "kettlebell turkish get-up (squat style), shoulders\n" +
            "kettlebell windmill, abdominals\n" +
            "kipping muscle up, lats\n" +
            "knee across the body, glutes\n" +
            "knee circles, calves\n" +
            "knee tuck jump, hamstrings\n" +
            "knee/hip raise on parallel bars, abdominals\n" +
            "kneeling arm drill, shoulders\n" +
            "kneeling cable crunch with alternating oblique twists, abdominals\n" +
            "kneeling cable triceps extension, triceps\n" +
            "kneeling forearm stretch, forearms\n" +
            "kneeling high pulley row, lats\n" +
            "kneeling hip flexor, quadriceps\n" +
            "kneeling jump squat, glutes\n" +
            "kneeling single-arm high pulley row, lats\n" +
            "kneeling squat, glutes\n" +
            "landmine 180's, abdominals\n" +
            "landmine linear jammer, shoulders\n" +
            "lateral bound, adductors\n" +
            "lateral box jump, adductors\n" +
            "lateral cone hops, adductors\n" +
            "lateral raise - with bands, shoulders\n" +
            "latissimus dorsi-smr, lats\n" +
            "leg extensions, quadriceps\n" +
            "leg lift, glutes\n" +
            "leg press, quadriceps\n" +
            "leg pull-in, abdominals\n" +
            "leg-over floor press, chest\n" +
            "leg-up hamstring stretch, hamstrings\n" +
            "leverage chest press, chest\n" +
            "leverage deadlift, quadriceps\n" +
            "leverage decline chest press, chest\n" +
            "leverage high row, middle back\n" +
            "leverage incline chest press, chest\n" +
            "leverage iso row, lats\n" +
            "leverage shoulder press, shoulders\n" +
            "leverage shrug, traps\n" +
            "linear 3-part start technique, hamstrings\n" +
            "linear acceleration wall drill, hamstrings\n" +
            "linear depth jump, quadriceps\n" +
            "log lift, shoulders\n" +
            "london bridges, lats\n" +
            "looking at ceiling, quadriceps\n" +
            "low cable crossover, chest\n" +
            "low cable triceps extension, triceps\n" +
            "low pulley row to neck, shoulders\n" +
            "lower back curl, abdominals\n" +
            "lower back-smr, lower back\n" +
            "lunge pass through, hamstrings\n" +
            "lunge sprint, quadriceps\n" +
            "lying bent leg groin, adductors\n" +
            "lying cable curl, biceps\n" +
            "lying cambered barbell row, middle back\n" +
            "lying close-grip bar curl on high pulley, biceps\n" +
            "lying close-grip barbell triceps extension behind the head, triceps\n" +
            "lying close-grip barbell triceps press to chin, triceps\n" +
            "lying crossover, abductors\n" +
            "lying dumbbell tricep extension, triceps\n" +
            "lying face down plate neck resistance, neck\n" +
            "lying face up plate neck resistance, neck\n" +
            "lying glute, glutes\n" +
            "lying hamstring, hamstrings\n" +
            "lying high bench barbell curl, biceps\n" +
            "lying leg curls, hamstrings\n" +
            "lying machine squat, quadriceps\n" +
            "lying one-arm lateral raise, shoulders\n" +
            "lying prone quadriceps, quadriceps\n" +
            "lying rear delt raise, shoulders\n" +
            "lying supine dumbbell curl, biceps\n" +
            "lying t-bar row, middle back\n" +
            "lying triceps press, triceps\n" +
            "machine bench press, chest\n" +
            "machine bicep curl, biceps\n" +
            "machine preacher curls, biceps\n" +
            "machine shoulder (military) press, shoulders\n" +
            "machine triceps extension, triceps\n" +
            "medicine ball chest pass, chest\n" +
            "medicine ball full twist, abdominals\n" +
            "medicine ball scoop throw, shoulders\n" +
            "middle back shrug, middle back\n" +
            "middle back stretch, middle back\n" +
            "mixed grip chin, middle back\n" +
            "monster walk, abductors\n" +
            "mountain climbers, quadriceps\n" +
            "moving claw series, hamstrings\n" +
            "muscle snatch, hamstrings\n" +
            "muscle up, lats\n" +
            "narrow stance hack squats, quadriceps\n" +
            "narrow stance leg press, quadriceps\n" +
            "narrow stance squats, quadriceps\n" +
            "natural glute ham raise, hamstrings\n" +
            "neck press, chest\n" +
            "neck-smr, neck\n" +
            "oblique crunches, abdominals\n" +
            "oblique crunches - on the floor, abdominals\n" +
            "olympic squat, quadriceps\n" +
            "on your side quad stretch, quadriceps\n" +
            "on-your-back quad stretch, quadriceps\n" +
            "one arm against wall, lats\n" +
            "one arm chin-up, middle back\n" +
            "one arm dumbbell bench press, chest\n" +
            "one arm dumbbell preacher curl, biceps\n" +
            "one arm floor press, triceps\n" +
            "one arm lat pulldown, lats\n" +
            "one arm pronated dumbbell triceps extension, triceps\n" +
            "one arm supinated dumbbell triceps extension, triceps\n" +
            "one half locust, quadriceps\n" +
            "one handed hang, lats\n" +
            "one knee to chest, glutes\n" +
            "one leg barbell squat, quadriceps\n" +
            "one-arm dumbbell row, middle back\n" +
            "one-arm flat bench dumbbell flye, chest\n" +
            "one-arm high-pulley cable side bends, abdominals\n" +
            "one-arm incline lateral raise, shoulders\n" +
            "one-arm kettlebell clean, hamstrings\n" +
            "one-arm kettlebell clean and jerk, shoulders\n" +
            "one-arm kettlebell floor press, chest\n" +
            "one-arm kettlebell jerk, shoulders\n" +
            "one-arm kettlebell military press to the side, shoulders\n" +
            "one-arm kettlebell para press, shoulders\n" +
            "one-arm kettlebell push press, shoulders\n" +
            "one-arm kettlebell row, middle back\n" +
            "one-arm kettlebell snatch, shoulders\n" +
            "one-arm kettlebell split jerk, shoulders\n" +
            "one-arm kettlebell split snatch, shoulders\n" +
            "one-arm kettlebell swings, hamstrings\n" +
            "one-arm long bar row, middle back\n" +
            "one-arm medicine ball slam, abdominals\n" +
            "one-arm open palm kettlebell clean, hamstrings\n" +
            "one-arm overhead kettlebell squats, quadriceps\n" +
            "one-arm side deadlift, quadriceps\n" +
            "one-arm side laterals, shoulders\n" +
            "one-legged cable kickback, glutes\n" +
            "open palm kettlebell clean, hamstrings\n" +
            "otis-up, abdominals\n" +
            "overhead cable curl, biceps\n" +
            "overhead lat, lats\n" +
            "overhead slam, lats\n" +
            "overhead squat, quadriceps\n" +
            "overhead stretch, abdominals\n" +
            "overhead triceps, triceps\n" +
            "pallof press with rotation, abdominals\n" +
            "palms-down dumbbell wrist curl over a bench, forearms\n" +
            "palms-down wrist curl over a bench, forearms\n" +
            "palms-up barbell wrist curl over a bench, forearms\n" +
            "palms-up dumbbell wrist curl over a bench, forearms\n" +
            "parallel bar dip, triceps\n" +
            "pelvic tilt into bridge, lower back\n" +
            "peroneals stretch, calves\n" +
            "peroneals-smr, calves\n" +
            "physioball hip bridge, glutes\n" +
            "pin presses, triceps\n" +
            "piriformis-smr, glutes\n" +
            "plank, abdominals\n" +
            "plate pinch, forearms\n" +
            "plate twist, abdominals\n" +
            "platform hamstring slides, hamstrings\n" +
            "plie dumbbell squat, quadriceps\n" +
            "plyo kettlebell pushups, chest\n" +
            "plyo push-up, chest\n" +
            "posterior tibialis stretch, calves\n" +
            "power clean, hamstrings\n" +
            "power clean from blocks, hamstrings\n" +
            "power jerk, quadriceps\n" +
            "power partials, shoulders\n" +
            "power snatch, hamstrings\n" +
            "power snatch from blocks, quadriceps\n" +
            "power stairs, hamstrings\n" +
            "preacher curl, biceps\n" +
            "preacher hammer dumbbell curl, biceps\n" +
            "press sit-up, abdominals\n" +
            "prone manual hamstring, hamstrings\n" +
            "prowler sprint, hamstrings\n" +
            "pull through, glutes\n" +
            "pullups, lats\n" +
            "push press, shoulders\n" +
            "push press - behind the neck, shoulders\n" +
            "push up to side plank, chest\n" +
            "push-up wide, chest\n" +
            "push-ups - close triceps position, triceps\n" +
            "push-ups with feet elevated, chest\n" +
            "push-ups with feet on an exercise ball, chest\n" +
            "pushups, chest\n" +
            "pushups (close and wide hand positions), chest\n" +
            "pyramid, lower back\n" +
            "quad stretch, quadriceps\n" +
            "quadriceps-smr, quadriceps\n" +
            "quick leap, quadriceps\n" +
            "rack delivery, shoulders\n" +
            "rack pull with bands, lower back\n" +
            "rack pulls, lower back\n" +
            "rear leg raises, quadriceps\n" +
            "recumbent bike, quadriceps\n" +
            "return push from stance, shoulders\n" +
            "reverse band bench press, triceps\n" +
            "reverse band box squat, quadriceps\n" +
            "reverse band deadlift, lower back\n" +
            "reverse band power squat, quadriceps\n" +
            "reverse band sumo deadlift, hamstrings\n" +
            "reverse barbell curl, biceps\n" +
            "reverse barbell preacher curls, biceps\n" +
            "reverse cable curl, biceps\n" +
            "reverse crunch, abdominals\n" +
            "reverse flyes, shoulders\n" +
            "reverse flyes with external rotation, shoulders\n" +
            "reverse grip bent-over rows, middle back\n" +
            "reverse grip triceps pushdown, triceps\n" +
            "reverse hyperextension, hamstrings\n" +
            "reverse machine flyes, shoulders\n" +
            "reverse plate curls, biceps\n" +
            "reverse triceps bench press, triceps\n" +
            "rhomboids-smr, middle back\n" +
            "rickshaw carry, forearms\n" +
            "rickshaw deadlift, quadriceps\n" +
            "ring dips, triceps\n" +
            "rocket jump, quadriceps\n" +
            "rocking standing calf raise, calves\n" +
            "rocky pull-ups/pulldowns, lats\n" +
            "romanian deadlift, hamstrings\n" +
            "romanian deadlift from deficit, hamstrings\n" +
            "rope climb, lats\n" +
            "rope crunch, abdominals\n" +
            "rope jumping, quadriceps\n" +
            "rope straight-arm pulldown, lats\n" +
            "round the world shoulder stretch, shoulders\n" +
            "rowing, stationary, quadriceps\n" +
            "runner's stretch, hamstrings\n" +
            "running, treadmill, quadriceps\n" +
            "russian twist, abdominals\n" +
            "sandbag load, quadriceps\n" +
            "scapular pull-up, traps\n" +
            "scissor kick, abdominals\n" +
            "scissors jump, quadriceps\n" +
            "seated band hamstring curl, hamstrings\n" +
            "seated barbell military press, shoulders\n" +
            "seated barbell twist, abdominals\n" +
            "seated bent-over one-arm dumbbell triceps extension, triceps\n" +
            "seated bent-over rear delt raise, shoulders\n" +
            "seated bent-over two-arm dumbbell triceps extension, triceps\n" +
            "seated biceps, biceps\n" +
            "seated cable rows, middle back\n" +
            "seated cable shoulder press, shoulders\n" +
            "seated calf raise, calves\n" +
            "seated calf stretch, calves\n" +
            "seated close-grip concentration barbell curl, biceps\n" +
            "seated dumbbell curl, biceps\n" +
            "seated dumbbell inner biceps curl, biceps\n" +
            "seated dumbbell palms-down wrist curl, forearms\n" +
            "seated dumbbell palms-up wrist curl, forearms\n" +
            "seated dumbbell press, shoulders\n" +
            "seated flat bench leg pull-in, abdominals\n" +
            "seated floor hamstring stretch, hamstrings\n" +
            "seated front deltoid, shoulders\n" +
            "seated glute, glutes\n" +
            "seated good mornings, lower back\n" +
            "seated hamstring, hamstrings\n" +
            "seated hamstring and calf stretch, hamstrings\n" +
            "seated head harness neck resistance, neck\n" +
            "seated leg curl, hamstrings\n" +
            "seated leg tucks, abdominals\n" +
            "seated one-arm cable pulley rows, middle back\n" +
            "seated one-arm dumbbell palms-down wrist curl, forearms\n" +
            "seated one-arm dumbbell palms-up wrist curl, forearms\n" +
            "seated overhead stretch, abdominals\n" +
            "seated palm-up barbell wrist curl, forearms\n" +
            "seated palms-down barbell wrist curl, forearms\n" +
            "seated side lateral raise, shoulders\n" +
            "seated triceps press, triceps\n" +
            "seated two-arm palms-up low-pulley wrist curl, forearms\n" +
            "see-saw press (alternating side press), shoulders\n" +
            "shotgun row, lats\n" +
            "shoulder circles, shoulders\n" +
            "shoulder press - with bands, shoulders\n" +
            "shoulder raise, shoulders\n" +
            "shoulder stretch, shoulders\n" +
            "side bridge, abdominals\n" +
            "side hop-sprint, quadriceps\n" +
            "side jackknife, abdominals\n" +
            "side lateral raise, shoulders\n" +
            "side laterals to front raise, shoulders\n" +
            "side leg raises, adductors\n" +
            "side lying groin stretch, adductors\n" +
            "side neck stretch, neck\n" +
            "side standing long jump, quadriceps\n" +
            "side to side box shuffle, quadriceps\n" +
            "side to side chins, lats\n" +
            "side wrist pull, shoulders\n" +
            "side-lying floor stretch, lats\n" +
            "single dumbbell raise, shoulders\n" +
            "single leg butt kick, quadriceps\n" +
            "single leg glute bridge, glutes\n" +
            "single leg push-off, quadriceps\n" +
            "single-arm cable crossover, chest\n" +
            "single-arm linear jammer, shoulders\n" +
            "single-arm push-up, chest\n" +
            "single-cone sprint drill, quadriceps\n" +
            "single-leg high box squat, quadriceps\n" +
            "single-leg hop progression, quadriceps\n" +
            "single-leg lateral hop, quadriceps\n" +
            "single-leg leg extension, quadriceps\n" +
            "single-leg stride jump, quadriceps\n" +
            "sit squats, quadriceps\n" +
            "sit-up, abdominals\n" +
            "skating, quadriceps\n" +
            "sled drag - harness, quadriceps\n" +
            "sled overhead backward walk, shoulders\n" +
            "sled overhead triceps extension, triceps\n" +
            "sled push, quadriceps\n" +
            "sled reverse flye, shoulders\n" +
            "sled row, middle back\n" +
            "sledgehammer swings, abdominals\n" +
            "smith incline shoulder raise, shoulders\n" +
            "smith machine behind the back shrug, traps\n" +
            "smith machine bench press, chest\n" +
            "smith machine bent over row, middle back\n" +
            "smith machine calf raise, calves\n" +
            "smith machine close-grip bench press, triceps\n" +
            "smith machine decline press, chest\n" +
            "smith machine hang power clean, hamstrings\n" +
            "smith machine hip raise, abdominals\n" +
            "smith machine incline bench press, chest\n" +
            "smith machine leg press, quadriceps\n" +
            "smith machine one-arm upright row, shoulders\n" +
            "smith machine overhead shoulder press, shoulders\n" +
            "smith machine pistol squat, quadriceps\n" +
            "smith machine reverse calf raises, calves\n" +
            "smith machine shrug, traps\n" +
            "smith machine squat, quadriceps\n" +
            "smith machine stiff-legged deadlift, hamstrings\n" +
            "smith machine upright row, traps\n" +
            "smith single-leg split squat, quadriceps\n" +
            "snatch, quadriceps\n" +
            "snatch balance, quadriceps\n" +
            "snatch deadlift, hamstrings\n" +
            "snatch from blocks, quadriceps\n" +
            "snatch pull, hamstrings\n" +
            "snatch shrug, traps\n" +
            "speed band overhead triceps, triceps\n" +
            "speed band pushdown, triceps\n" +
            "speed box squat, quadriceps\n" +
            "speed squats, quadriceps\n" +
            "spell caster, abdominals\n" +
            "spider crawl, abdominals\n" +
            "spider curl, biceps\n" +
            "spinal stretch, middle back\n" +
            "split clean, quadriceps\n" +
            "split jerk, quadriceps\n" +
            "split jump, quadriceps\n" +
            "split snatch, hamstrings\n" +
            "split squat with dumbbells, quadriceps\n" +
            "split squats, hamstrings\n" +
            "squat jerk, quadriceps\n" +
            "squat with bands, quadriceps\n" +
            "squat with chains, quadriceps\n" +
            "squat with plate movers, quadriceps\n" +
            "squats - with bands, quadriceps\n" +
            "stairmaster, quadriceps\n" +
            "standing alternating dumbbell press, shoulders\n" +
            "standing barbell calf raise, calves\n" +
            "standing barbell press behind neck, shoulders\n" +
            "standing bent-over one-arm dumbbell triceps extension, triceps\n" +
            "standing bent-over two-arm dumbbell triceps extension, triceps\n" +
            "standing biceps cable curl, biceps\n" +
            "standing biceps stretch, biceps\n" +
            "standing bradford press, shoulders\n" +
            "standing cable chest press, chest\n" +
            "standing cable lift, abdominals\n" +
            "standing cable wood chop, abdominals\n" +
            "standing calf raises, calves\n" +
            "standing concentration curl, biceps\n" +
            "standing dumbbell calf raise, calves\n" +
            "standing dumbbell press, shoulders\n" +
            "standing dumbbell reverse curl, biceps\n" +
            "standing dumbbell straight-arm front delt raise above head, shoulders\n" +
            "standing dumbbell triceps extension, triceps\n" +
            "standing dumbbell upright row, traps\n" +
            "standing elevated quad stretch, quadriceps\n" +
            "standing front barbell raise over head, shoulders\n" +
            "standing gastrocnemius calf stretch, calves\n" +
            "standing hamstring and calf stretch, hamstrings\n" +
            "standing hip circles, abductors\n" +
            "standing hip flexors, quadriceps\n" +
            "standing inner-biceps curl, biceps\n" +
            "standing lateral stretch, abdominals\n" +
            "standing leg curl, hamstrings\n" +
            "standing long jump, quadriceps\n" +
            "standing low-pulley deltoid raise, shoulders\n" +
            "standing low-pulley one-arm triceps extension, triceps\n" +
            "standing military press, shoulders\n" +
            "standing olympic plate hand squeeze, forearms\n" +
            "standing one-arm cable curl, biceps\n" +
            "standing one-arm dumbbell curl over incline bench, biceps\n" +
            "standing one-arm dumbbell triceps extension, triceps\n" +
            "standing overhead barbell triceps extension, triceps\n" +
            "standing palm-in one-arm dumbbell press, shoulders\n" +
            "standing palms-in dumbbell press, shoulders\n" +
            "standing palms-up barbell behind the back wrist curl, forearms\n" +
            "standing pelvic tilt, lower back\n" +
            "standing rope crunch, abdominals\n" +
            "standing soleus and achilles stretch, calves\n" +
            "standing toe touches, hamstrings\n" +
            "standing towel triceps extension, triceps\n" +
            "standing two-arm overhead throw, shoulders\n" +
            "star jump, quadriceps\n" +
            "step mill, quadriceps\n" +
            "step-up with knee raise, glutes\n" +
            "stiff leg barbell good morning, lower back\n" +
            "stiff-legged barbell deadlift, hamstrings\n" +
            "stiff-legged dumbbell deadlift, hamstrings\n" +
            "stomach vacuum, abdominals\n" +
            "straight bar bench mid rows, middle back\n" +
            "straight raises on incline bench, shoulders\n" +
            "straight-arm dumbbell pullover, chest\n" +
            "straight-arm pulldown, lats\n" +
            "stride jump crossover, quadriceps\n" +
            "sumo deadlift, hamstrings\n" +
            "sumo deadlift with bands, hamstrings\n" +
            "sumo deadlift with chains, hamstrings\n" +
            "superman, lower back\n" +
            "supine chest throw, triceps\n" +
            "supine one-arm overhead throw, abdominals\n" +
            "supine two-arm overhead throw, abdominals\n" +
            "suspended push-up, chest\n" +
            "suspended reverse crunch, abdominals\n" +
            "suspended row, middle back\n" +
            "suspended split squat, quadriceps\n" +
            "t-bar row with handle, middle back\n" +
            "tate press, triceps\n" +
            "the straddle, hamstrings\n" +
            "thigh abductor, abductors\n" +
            "thigh adductor, adductors\n" +
            "tire flip, quadriceps\n" +
            "toe touchers, abdominals\n" +
            "torso rotation, abdominals\n" +
            "trail running/walking, quadriceps\n" +
            "trap bar deadlift, quadriceps\n" +
            "tricep dumbbell kickback, triceps\n" +
            "tricep side stretch, triceps\n" +
            "triceps overhead extension with rope, triceps\n" +
            "triceps pushdown, triceps\n" +
            "triceps pushdown - rope attachment, triceps\n" +
            "triceps pushdown - v-bar attachment, triceps\n" +
            "triceps stretch, triceps\n" +
            "tuck crunch, abdominals\n" +
            "two-arm dumbbell preacher curl, biceps\n" +
            "two-arm kettlebell clean, shoulders\n" +
            "two-arm kettlebell jerk, shoulders\n" +
            "two-arm kettlebell military press, shoulders\n" +
            "two-arm kettlebell row, middle back\n" +
            "underhand cable pulldowns, lats\n" +
            "upper back stretch, middle back\n" +
            "upper back-leg grab, hamstrings\n" +
            "upright barbell row, shoulders\n" +
            "upright cable row, traps\n" +
            "upright row - with bands, traps\n" +
            "upward stretch, shoulders\n" +
            "v-bar pulldown, lats\n" +
            "v-bar pullup, lats\n" +
            "vertical swing, hamstrings\n" +
            "walking, treadmill, quadriceps\n" +
            "weighted ball hyperextension, lower back\n" +
            "weighted ball side bend, abdominals\n" +
            "weighted bench dip, triceps\n" +
            "weighted crunches, abdominals\n" +
            "weighted jump squat, quadriceps\n" +
            "weighted pull ups, lats\n" +
            "weighted sissy squat, quadriceps\n" +
            "weighted sit-ups - with bands, abdominals\n" +
            "weighted squat, quadriceps\n" +
            "wide stance barbell squat, quadriceps\n" +
            "wide stance stiff legs, hamstrings\n" +
            "wide-grip barbell bench press, chest\n" +
            "wide-grip decline barbell bench press, chest\n" +
            "wide-grip decline barbell pullover, chest\n" +
            "wide-grip lat pulldown, lats\n" +
            "wide-grip pulldown behind the neck, lats\n" +
            "wide-grip rear pull-up, lats\n" +
            "wide-grip standing barbell curl, biceps\n" +
            "wind sprints, abdominals\n" +
            "windmills, abductors\n" +
            "world's greatest stretch, hamstrings\n" +
            "wrist circles, forearms\n" +
            "wrist roller, forearms\n" +
            "wrist rotations with straight bar, forearms\n" +
            "yoke walk, quadriceps\n" +
            "zercher squats, quadriceps\n" +
            "zottman curl, biceps\n" +
            "zottman preacher curl, biceps";
}