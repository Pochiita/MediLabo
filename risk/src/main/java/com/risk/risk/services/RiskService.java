package com.risk.risk.services;

import com.risk.risk.DTO.PatientDTO;
import com.risk.risk.models.Gender;
import com.risk.risk.models.Note;
import com.risk.risk.proxies.NoteProxy;
import com.risk.risk.proxies.PatientProxy;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class RiskService {

    private final PatientProxy patientProxy;

    private final NoteProxy noteProxy;

    public RiskService(PatientProxy patientProxy, NoteProxy noteProxy) {
        this.patientProxy = patientProxy;
        this.noteProxy = noteProxy;
    }

    /**
     * Checks if the patient is a man under 30 years old.
     *
     * @param patient The patient to check.
     * @return True if the patient is a man under 30, false otherwise.
     */
    private boolean isManUnder30(PatientDTO patient){
        return getAge(patient.getBd()) <30 && patient.getGender().equals(Gender.M);
    }

    /**
     * Checks if the patient is a woman under 30 years old.
     *
     * @param patient The patient to check.
     * @return True if the patient is a woman under 30, false otherwise.
     */
    private boolean isWomanUnder30(PatientDTO patient){
        return getAge(patient.getBd()) <30 && patient.getGender().equals(Gender.F);

    }

    /**
     * Calculates the age of the patient based on their birth date.
     *
     * @param birthDate The patient's birth date.
     * @return The patient's age in years.
     */
    private int getAge(LocalDate birthDate){
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate,currentDate);
        return period.getYears();
    }

    /**
     * Counts the number of trigger notes in the patient's notes.
     *
     * @param notes The patient's notes.
     * @return The number of trigger notes.
     */
    private int countTriggersNotes (List<Note> notes){
        int count = 0;
        for (TriggerList trigger:TriggerList.values()) {
            String toCompare = trigger.equals(TriggerList.Hémoglobine_A1C) ? "Hémoglobine A1C" : trigger.name();
            for (Note note:notes) {
                String text = note.getNote();
                if (text.contains(toCompare)){
                    count++;
                }
                break;
            }
        }
        return count;
    }

    /**
     * Determines the risk level of the patient based on their age, gender, and notes.
     *
     * @param patientId The ID of the patient.
     * @return The risk level of the patient.
     * @throws Exception If an error occurs while retrieving patient data.
     */
    public String getRiskLevel(int patientId) throws Exception {
        try {
            PatientDTO patient = patientProxy.getPatientById(patientId).getBody();
            List<Note> notes = noteProxy.getNotesByPatient(patientId).getBody();

            int triggerCount = countTriggersNotes(notes);
            System.out.println(triggerCount);
            if (triggerCount == 0) {
                return RiskList.NONE.name();
            } else if (triggerCount >= 2 && triggerCount <= 5 && getAge(patient.getBd()) > 30) {
                return RiskList.BORDERLINE.name();
            } else if (isManUnder30(patient) && triggerCount == 3 ||
                    isWomanUnder30(patient) && triggerCount == 4 ||
                    getAge(patient.getBd()) > 30 && (triggerCount == 6 || triggerCount == 7)) {
                return RiskList.IN_DANGER.name();
            } else if (isManUnder30(patient) && triggerCount >= 5 ||
                    isWomanUnder30(patient) && triggerCount >= 7 ||
                    getAge(patient.getBd()) > 30 && triggerCount >= 8) {
                return RiskList.EARLY_ONSET.name();
            } else {
                return RiskList.NONE.name();
            }
        }catch (Exception e){
            throw new Exception("Impossible to define risk level");
        }

    }
}
