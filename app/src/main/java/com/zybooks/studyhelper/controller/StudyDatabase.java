package com.zybooks.studyhelper.controller;

import com.zybooks.studyhelper.model.Question;
import com.zybooks.studyhelper.model.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudyDatabase {

    private static StudyDatabase mStudyDb;
    private final List<Subject> mSubjects;
    private final HashMap<Long, List<Question>> mQuestions;

    public enum SubjectSortOrder { ALPHABETIC, UPDATE_DESC, UPDATE_ASC };

    public static StudyDatabase getInstance() {
        if (mStudyDb == null) {
            mStudyDb = new StudyDatabase();
        }
        return mStudyDb;
    }

    // Prevent instantiating from outside the class
    private StudyDatabase() {
        mSubjects = new ArrayList<>();
        mQuestions = new HashMap<>();

        // Add a few subjects and questions
        Subject subject = new Subject("Math");
        subject.setId(1);
        addSubject(subject);

        Question question = new Question();
        question.setId(1);
        question.setText("What is 2 + 3?");
        question.setAnswer("2 + 3 = 5");
        question.setSubjectId(1);
        addQuestion(question);

        question = new Question();
        question.setId(2);
        question.setText("What is pi?");
        question.setAnswer("Pi is the ratio of a circle's circumference to its diameter.");
        question.setSubjectId(1);
        addQuestion(question);

        question = new Question();
        question.setId(3);
        question.setText("Multiply: (x – 4)(x + 5)");
        question.setAnswer("x2 + x - 20.");
        question.setSubjectId(1);
        addQuestion(question);

        question = new Question();
        question.setId(4);
        question.setText("Factor: 5x2 – 15x – 20.");
        question.setAnswer("5(x-4)(x+1).");
        question.setSubjectId(1);
        addQuestion(question);

        subject = new Subject("History");
        subject.setId(2);
        addSubject(subject);

        question = new Question();
        question.setId(5);
        question.setText("On what date was the U.S. Declaration of Independence adopted?");
        question.setAnswer("July 4, 1776.");
        question.setSubjectId(2);
        addQuestion(question);

        question = new Question();
        question.setId(6);
        question.setText("What tribe was Pocahontas from?");
        question.setAnswer("The Powhatan tribal nation.");
        question.setSubjectId(2);
        addQuestion(question);

        question = new Question();
        question.setId(7);
        question.setText("What year was the Jamestown settlement established? ");
        question.setAnswer("In 1607");
        question.setSubjectId(2);
        addQuestion(question);

        subject = new Subject("Computing");
        subject.setId(3);
        addSubject(subject);

        question = new Question();
        question.setId(8);
        question.setText("What is does RAM stand for?");
        question.setAnswer("random access memory");
        question.setSubjectId(3);
        addQuestion(question);

        question = new Question();
        question.setId(9);
        question.setText("What does SSD stand for?");
        question.setAnswer("solid-state drive");
        question.setSubjectId(3);
        addQuestion(question);

        subject = new Subject("Science");
        subject.setId(4);
        addSubject(subject);

        question = new Question();
        question.setId(10);
        question.setText("What does DNA stand for?");
        question.setAnswer("Deoxyribonucleic acid");
        question.setSubjectId(4);
        addQuestion(question);

        question = new Question();
        question.setId(11);
        question.setText("How many bones are in the human body?");
        question.setAnswer("206");
        question.setSubjectId(4);
        addQuestion(question);

        question = new Question();
        question.setId(12);
        question.setText("The concept of gravity was discovered by which famous physicist?");
        question.setAnswer("Sir Isaac Newton");
        question.setSubjectId(4);
        addQuestion(question);


    }

    public void addSubject(Subject subject) {
        mSubjects.add(subject);
        List<Question> questionList = new ArrayList<>();
        mQuestions.put(subject.getId(), questionList);
    }

    public Subject getSubject(long subjectId) {
        for (Subject subject: mSubjects) {
            if (subject.getId() == subjectId) {
                return subject;
            }
        }

        return null;
    }

    public List<Subject> getSubjects(SubjectSortOrder order) {
        return mSubjects;
    }

    public void addQuestion(Question question) {
        List<Question> questionList = mQuestions.get(question.getSubjectId());
        if (questionList != null) {
            questionList.add(question);
        }
    }

    public List<Question> getQuestions(long subjectId) {
        return mQuestions.get(subjectId);
    }
}