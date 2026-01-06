package com.interview.constant;

/**
 * Fixed prompt templates for deterministic LLM evaluation
 * These templates define the evaluation criteria and output format
 * Temperature = 0 ensures consistent output for same inputs
 */
public class PromptTemplate {

    public static final String EVALUATION_PROMPT_TEMPLATE = """
        You are an expert technical interviewer and hiring manager. Your task is to evaluate a candidate's interview performance based on a job description and interview transcript.

        IMPORTANT: Your response MUST be valid JSON that matches the exact schema provided below. Do not include any text outside the JSON.

        ---

        JOB DESCRIPTION:
        {JOB_DESCRIPTION}

        ---

        INTERVIEW TRANSCRIPT:
        {INTERVIEW_TRANSCRIPT}

        ---

        SENIORITY LEVEL EXPECTED:
        {SENIORITY_LEVEL}

        ---

        EVALUATION INSTRUCTIONS:

        1. CANDIDATE EVALUATION:
           - Analyze the candidate's responses against the job description
           - Extract explicit skills mentioned in the transcript (do NOT infer or assume skills not discussed)
           - Assign a score (0-100) to each identified skill based on demonstrated proficiency
           - Provide an overall score (0-100) reflecting job fit
           - List 3-5 key strengths with evidence from transcript
           - List 3-5 gaps or areas needing improvement
           - Identify 2-3 risk areas (red flags, unclear answers, missing critical skills)
           - Generate a hiring recommendation: "Strong Hire", "Hire", "Maybe", "No Hire", or "Reject"
           - Evaluate seniority match: Does this candidate align with the expected seniority level?
           - JD Fit: Rate how well the candidate matches the job description

        2. META EVALUATION:
           - overallSummary: 2-3 sentence executive summary
           - seniorityMatch: Assessment of seniority alignment
           - confidenceLevel: "High", "Medium", or "Low" based on clarity of evaluation

        3. OUTPUT FORMAT:
        Return a JSON object with this EXACT structure (no additional fields):
        {
          "candidate": {
            "name": null,
            "overallScore": <number 0-100>,
            "hiringRecommendation": "<string>",
            "jdFit": "<string>",
            "skills": [
              { "name": "<skill name>", "score": <number 0-100> }
            ],
            "strengths": ["<strength 1>", "<strength 2>", ...],
            "gaps": ["<gap 1>", "<gap 2>", ...],
            "riskAreas": ["<risk 1>", "<risk 2>", ...]
          },
          "meta": {
            "overallSummary": "<summary>",
            "seniorityMatch": "<assessment>",
            "confidenceLevel": "<High|Medium|Low>"
          }
        }

        ---

        Begin evaluation now. Return ONLY the JSON object, no additional text.""";

    public static final String INTERVIEWER_EVALUATION_PROMPT_TEMPLATE = """
        You are an expert in assessing interview quality. Evaluate the interviewer's performance based on the following job description and interview transcript.

        INTERVIEW TRANSCRIPT:
        {INTERVIEW_TRANSCRIPT}

        JOB DESCRIPTION:
        {JOB_DESCRIPTION}

        ---

        INTERVIEWER EVALUATION INSTRUCTIONS:

        1. Core JD Coverage: Did the interviewer ask questions that adequately cover the key requirements in the job description?
        2. Question Quality: Were questions clear, technical, behavioral, and appropriate? Did they elicit meaningful responses?
        3. Follow-Up Assessment: Were there missed opportunities for deeper exploration or clarification?
        4. Follow-Up Questions: List 2-3 critical questions that should have been asked based on the JD.

        ---

        OUTPUT FORMAT:
        Return a JSON object with this EXACT structure (no additional fields):
        {
          "coreJdCoverage": "<assessment>",
          "questionQuality": "<assessment>",
          "followUpNeeded": <boolean>,
          "followUpQuestions": ["<question 1>", "<question 2>", ...]
        }

        ---

        Begin evaluation now. Return ONLY the JSON object, no additional text.""";

    private PromptTemplate() {
        // Utility class, no instantiation
    }

}

