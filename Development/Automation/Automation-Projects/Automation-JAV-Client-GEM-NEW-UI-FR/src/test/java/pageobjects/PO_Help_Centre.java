package pageobjects;
// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;   // Selenium WebDriver

import framework.utilities.FW_ConfigMgr;// Automation framework customizations for Appian
import framework.utilities.FW_StringUtils;   // Automation framework Configuration Manager to retrieve testConfig.properties values

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
public class PO_Help_Centre extends PO_Required_Documents {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    
   
    private static final String LO_TXT_HELP_CENTER_PAGE_VERIFY = "//span[contains(text(), \"Centre d'aide \")]";
    private static final String LO_BUT_CONTACT_US = "//span[contains(text(), 'NOUS JOINDRE')]";
    private static final String LO_TXT_HOW_CAN_WE_ASSIST_YOU = "//h2[contains(text(), 'COMMENT POUVONS-NOUS VOUS AIDER?')]";
    private static final String LO_TXT_CUSTOMER_RELATIONS_CARD = "//div[h3/span[contains(text(), 'Faire une plainte')]]";
    private static final String LO_TXT_CUSTOMER_RELATIONS = "//h3/span[contains(text(), 'Relations clients')]";
    private static final String LO_TXT_CUSTOMER_RELATIONS_VERIFY = "//h2/span[contains(text(), 'Relations clients')]";
    private static final String LO_EDT_POLICY_NUMBER = "//div[label='Numéro de la police']/following-sibling::div//input";
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label='Numéro de réclamation Global Excel']/following-sibling::div//input";
    private static final String LO_EDT_FIRST_NAME = "//div[label='Prénom']/following-sibling::div//div//input";
    private static final String LO_EDT_LAST_NAME = "//div[label='Nom de famille']/following-sibling::div//div//input";
    private static final String LO_EDT_DATE_OF_BIRTH = "//div[label='Date de naissance']/following-sibling::div//div//input";
    private static final String LO_EDT_EMAIL = "//div[label='Adresse courriel']/following-sibling::div//div//input";
    private static final String LO_EDT_PHONE_NUMBER = "//div[label='Numéro de téléphone']/following-sibling::div//div//input";
    private static final String LO_EDT_ALTERNATE_PHONE_NUMBER = "//div[label='Numéro de téléphone alternatif']/following-sibling::div//div//input";
    private static final String LO_EDT_TEXT_TEXTAREA= "//div[label='Quelle est votre demande / comment pouvons-nous vous aider? (Un maximum de 2000 caractères est permis.)']/following-sibling::div//textarea";
    private static final String LO_BUT_VIEW_CHECK_CLAIM_STATUS = "//div[h2[span[contains(text(), \"Vérifier l'état d'une réclamation\")]]]/following-sibling::div//span[text()='CLIQUER ICI']";
    private static final String LO_BUT_VIEW_SUBMIT_DOCUMENTS = "//div[h2[span[contains(text(), 'Envoyer des documents')]]]/following-sibling::div//span[contains(text(), 'CLIQUER ICI')]";
    private static final String LO_TXT_SUBMIT_BILLS_OR_DOCUMENTS_SECTION = "//div//h2[contains(text(), 'SOUMISSION DE FACTURES OU DOCUMENTS')]";
    private static final String LO_TXT_CUSTOMER_RELATIONS_FORM_SECTION = "//h2/span[text()='Relations clients']";
    //private static final String LO_TXT_CUSTOMER_RELATIONS_FORM_SECTION = "//h2/span[contains(text(), 'Faire une plainte')]";
    private static final String LO_LNK_CLICK_HERE = "//strong[a='Cliquez ici']";
    private static final String LO_LST_WHAT_YOU_NEED_TO_SUBMIT = "//div[span=\"Je dois soumettre:\"]/following-sibling::div//div[span='--Sélectionner--']";
    private static final String LO_LST_CLAIM_TYPE = "//div[span='Type de réclamation ']/following-sibling::div//div[span='Type de réclamation ']";
    private static final String LO_LST_DOCUMENT_TYPE = "//div[span='Type de document']/following-sibling::div//div[span='Type de document']";
    private static final String LO_LST_DOCUMENT_TYPE2 = "";
    private static final String LO_DOC_DOCUMENT_TYPE1 = "//h3[a[span[contains(text(), 'Type de document 1')]]]/following-sibling::div//input";
    private static final String LO_DOC_DOCUMENT_TYPE2 = "(//div[div[div[p='Les types de fichiers acceptés sont pdf, tiff, png, jpeg, jpg, gif, bmp, doc, docx, rtf, txt, odt.']]])[2]/following-sibling::div//input";
    private static final String LO_BUT_ADD_ANOTHER_DOCUMENT = "//a[contains(text(), '+ ')]";
    private static final String LO_TXT_CLAIM_STATUS_CARD = "//span/strong[contains(text(), 'État de votre réclamation')]";
    private static final String LO_TXT_CLAIM_STATUS_SECTION = "//h2[contains(text(), \"ÉTAT DE VOTRE RÉCLAMATION\")]";
    private static final String LO_LNK_VIEW_YOUR_CLAIM_STATUS= "//a[contains(text(), \"Consulter l'état de votre réclamation\")]";
    private static final String LO_TXT_SUBMIT_BILLS_OR_DOCUMENTS_CARD= "//span/strong[contains(text(), 'Soumission de factures ou documents')]";
    private static final String LO_TXT_VALID_EMARGENCY_ASSISTANCE = "//div[h2[contains(text(), \"Assistance en cas d'urgence\")]]";
    private static final String LO_TXT_VALID_EMERGENCY_ASSISTANCE_NUMBER = "//span[strong='+1 819-566-3970']";
    private static final String LO_BUT_GENERAL_QUESTION= "//span/strong[contains(text(), 'Questions générales')]";
    private static final String LO_TXT_GENERAL_QUESTIONS_VERIFY = "//h2[contains(text(), 'QUESTIONS GÉNÉRALES')]";
    private static final String LO_TXT_VALID_MGB_EMERGENCY_ASSISTANCE_NUMBER = "//span[strong='+1 819-566-8335']";
    private static final String LO_TXT_FQA = "//div[contains(text(),'Comment vais-je savoir quand ma réclamation est réglée?')]";
    private static final String LO_TXT_SECOND_FAQ = "//div[contains(text(),'Dans combien de temps ma réclamation sera-t-elle réglée? ')]";
    private static final String LO_TXT_THIRD_FAQ = "//div[contains(text(),'À quel moment vais-je recevoir mon numéro de réclamation?')]";
    private static final String LO_TXT_FIRST_QUESTION_RESPONSE = "//p[contains(text(),'Pour suivre l’état de votre réclamation, rendez-vous à la section État de la réclamation.')]";
    private static final String LO_TXT_SECOND_QUESTION_RESPONSE = "//p[contains(text(),'Nous nous efforçons de régler votre réclamation le plus efficacement possible. Assurez-vous de fournir tous les documents exigés dans les meilleurs délais afin d’accélérer le traitement de votre réclamation. Nous rendons une décision sur la plupart des réclamations dans les 30 jours suivant la réception des documents requis.')]";
    private static final String LO_TXT_THIRD_QUESTION_RESPONSE = "//p[contains(text(),'Lorsque vous soumettez les documents requis et confirmez les renseignements de votre réclamation, notamment votre nom, votre date de naissance ainsi que la raison pour laquelle vous soumettez une demande, une réclamation sera créée et vous recevrez votre numéro de réclamation par courriel.')]";
    private static final String LO_LINK_VIEW_ALL_FAQs = "//span[contains(text(),'Consulter la FAQ')]";
    private static final String LO_TXT_TRAVEL_AND_ASSISTANCE = "//strong[contains(text(),'Voyage et assistance')]";
    private static final String LO_TXT_CLAIMING = "//strong[contains(text(),'Réclamations')]";
    private static final String LO_SLCT_EMERGENCY_TRAVEL_ASSISTANCE = "//h3/span[contains(text(), \"Assistance Voyage\")]";
    private static final String LO_TXT_EMERGENCY_TRAVEL_ASSISTANCE = "//h3/span[contains(text(), \"Assistance Voyage\")]";
    private static final String LO_TXT_VALID_CONSUMER_NUMBER = "//p[contains(text(), 'Consumer or Small Business Cards')]";
    private static final String LO_TXT_VALID_COMERCIAL_NUMBER = "//p[contains(text(), 'Commercial or Scotia Visa Business Cards')]";
    private static final String LO_IMG_MANULIFE_LOGO_TOP = "//img[@alt='Manulife Claim Center Page']";
    private static final String LO_RAD_RELATED_TO_CLAIM_DECISION_LETTER_NO = "//label[text()='Non']";
    private static final String LO_LST_SELECT_TOPIC = "//div[@role='combobox']";
    private static final String LO_DOC_UPLOAD = "//div[@class='MultipleFileUploadWidget---uploads_wrapper MultipleFileUploadWidget---drag_drop_zone_wrapper']/input";
    private static final String LO_IMG_GEM_TOP_LOGO_MGB = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_fr_ManulifeGroupBenefits.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_ManulifeGroupBenefits.png']";
    private static final String LO_LNK_HELP_CENTRE_TOP = "//p[span[a[(span/span[@class='IconWidget---inLightBackground'][not(following-sibling::span)]) or (span[@class='IconWidget---inLightBackground'] and text()='HELP CENTRE')]]]";
    private static final String LO_BUT_FRANÇAIS = "//p[span[a[(span[span[@class='ColorText---color_custom'] and span[contains(text(), 'EN')]]) or (span[@class='IconWidget---inLightBackground'] and span[contains(text(), 'ENGLISH')])]]]";
    private static final String LO_TXT_MAILING_ADDRESS_HEADING = "//h2/span[text()='Mailing Address Information']";
    private static final String LO_TXT_MAILING_ADDRESS_HEADING_SUB_LEFT_MANULIFE = "(//p/strong[contains(text(), 'Manulife')])[1]";
    private static final String LO_TXT_MAILING_ADDRESS_LEFT = "(//div/p[strong])[1]";
    private static final String LO_TXT_MAILING_ADDRESS_HEADING_SUB_RIGHT_MANULIFE = "(//p/strong[contains(text(), 'Manulife')])[2]";
    private static final String LO_TXT_MAILING_ADDRESS_RIGHT = "(//div/p[strong])[2]";
    private static final String LO_TXT_VERIFY_SEND_US_MESSAGE_CONTAINS_CONTACT_US = "//div[h2[contains(text(), \"Nous envoyer un message\")]]";
    private static final String LO_TXT_VERIFY_CHECK_CLAIM_STATUS_CARD = "//div[h2[contains(text(), \"Vérifier l'état d'une réclamation\")]]";
    private static final String LO_BUT_CHECK_CLAIM_STATUS = "//div//span[contains(text(),\"Vérifier l'état d'une réclamation\")]";
    private static final String LO_TXT_VERIFY_SUBMIT_DOCUMENTS_CARD = "//div[h2[contains(text(), \"Envoyer des documents\")]]";
    private static final String LO_BUT_SUBMIT_DOCUMENTS = "//div//span[contains(text(),\"Envoyer des documents\")]";
    private static final String LO_BUT_BACK = "//span[contains(text(), 'Retour')]";
    private static final String LO_TXT_VERIFY_FAQ_SECTION = "//div[h2[contains(text(), 'Foire aux questions (FAQ)')]]";
    private static final String LO_BUT_VIEW_ALL_FAQS = "//span[contains(text(), 'Consulter la FAQ')]";
    private static final String LO_TXT_VERIFY_MAILING_ADDRESSES = "//div[h2[contains(text(), 'Adresse postale')]]";
    private static final String LO_TXT_TRAVEL_AND_ASSISTANCE_FIRST_QUESTION = "//div[contains(text(),\"Quelles informations d'assurance dois-je apporter lors de mon voyage?\")]";
    private static final String LO_TXT_TRAVEL_AND_ASSISTANCE_SECOND_QUESTION = "//div[contains(text(),\"Que dois-je faire si j'ai une urgence médicale pendant mon voyage?\")]";
    private static final String LO_TXT_TRAVEL_AND_ASSISTANCE_THIRD_QUESTION = "//div[contains(text(),\"Que faire si je suis incapable de vous appeler?\")]";
    private static final String LO_TXT_TRAVEL_AND_ASSISTANCE_FOURTH_QUESTION = "//div[contains(text(),\"Si j'ai besoin d'assistance médicale, pouvez-vous me recommander un médecin ou une clinique?\")]";
    private static final String LO_TXT_TRAVEL_AND_ASSISTANCE_FIFTH_QUESTION = "//div[contains(text(),\"Quel est le rôle de Global Excel? / Pourquoi Global Excel m'a contacté?\")]";
    private static final String LO_TXT_TRAVEL_AND_ASSISTANCE_FIRST_QUESTION_RESPONSE = "//p[contains(text(),\"Il est important d’avoir vos documents d’assurance avec vous en tout temps lorsque vous voyagez à l’extérieur de votre province ou territoire de résidence. Ces documents contiennent des informations clés dont vous pourriez avoir besoin, telles que le numéro de téléphone pour joindre les équipes d'assistance et des réclamations de Global Excel, votre numéro de police ou de certificat ainsi que d'autres détails importants sur votre couverture.\")]";
    private static final String LO_TXT_TRAVEL_AND_ASSISTANCE_SECOND_QUESTION_RESPONSE = "//p[contains(text(),\"Veuillez nous appeler dès que possible, ou dès que votre état de santé vous le permet, de préférence avant de recevoir des soins, pour que nous puissions vous guider et vous diriger vers un hôpital, une clinique ou un médecin qui nous facturera les frais directement. Il est important de noter que certains traitements doivent être approuvés au préalable. Notre équipe pourra vous expliquer ce que cela signifie pour vous.\")]";
    private static final String LO_TXT_TRAVEL_AND_ASSISTANCE_THIRD_QUESTION_RESPONSE = "//p[contains(text(),\"Nous comprenons que dans certaines situations d’urgence, il vous sera impossible de nous contacter avant de recevoir des soins médicaux. Si cela vous arrive, demandez à un ami, à un parent ou même à l’hôpital ou au cabinet du médecin de nous appeler en votre nom dès que possible.\")]";
    private static final String LO_TXT_TRAVEL_AND_ASSISTANCE_FOURTH_QUESTION_RESPONSE = "//p[contains(text(),\"Oui. Si vous détenez une couverture médicale gérée par Global Excel, c’est avec plaisir que nous vous aiderons à trouver un médecin ou une clinique dans votre région. Vous pouvez consulter la page Centre d’aide et sélectionnez l’option appropriée dans la section Nous joindre ou nous appeler en composant le numéro d’assistance d’urgence inscrit dans vos documents d’assurance.\")]";
    private static final String LO_TXT_TRAVEL_AND_ASSISTANCE_FIFTH_QUESTION_RESPONSE = "//p[contains(text(),\"Gestion Global Excel est l'un des principaux fournisseurs de services de gestion des réclamations, de contrôle des coûts et d'assistance médicale pour les assureurs, les réassureurs et les tiers administrateurs du monde entier.Votre fournisseur d'assurance a désigné Gestion Global Excel (Global Excel) comme tiers administrateur de votre dossier de réclamation. Global Excel fournira des services et de l'assistance tout au long du processus de réclamation.\")]";
    private static final String LO_TXT_CLAIMING_QUESTIONS_FIRST_QUESTION = "//div[contains(text(),\"Que dois-je faire si j'ai reçu des factures?\")]";
    private static final String LO_TXT_CLAIMING_QUESTIONS_SECOND_QUESTION = "//div[contains(text(),\"Comment puis-je communiquer avec vous au sujet de ma réclamation?\")]";
    private static final String LO_TXT_CLAIMING_QUESTIONS_THIRD_QUESTION = "//div[contains(text(),\"Que dois-je faire si j'ai des dépenses personnelles?\")]";
    private static final String LO_TXT_CLAIMING_QUESTIONS_FOURTH_QUESTION = "//div[contains(text(),\"Dois-je vous envoyer les documents originaux ou acceptez-vous des copies?\")]";
    private static final String LO_TXT_CLAIMING_QUESTIONS_FIFTH_QUESTION = "//div[contains(text(),\"En quelle devise allez-vous me rembourser?\")]";
    private static final String LO_TXT_CLAIMING_QUESTIONS_SIXTH_QUESTION = "//div[contains(text(),\"Quelle est votre adresse postale?\")]";
    private static final String LO_TXT_CLAIMING_QUESTIONS_SEVENTH_QUESTION = "//div[contains(text(),\"Comment faire pour soumettre une réclamation?\")]";
    private static final String LO_TXT_CLAIMING_QUESTIONS_EIGHTH_QUESTION = "//div[contains(text(),\"Comment vais-je savoir quand ma réclamation est réglée?\")]";
    private static final String LO_TXT_CLAIMING_QUESTIONS_NINTH_QUESTION = "//div[contains(text(),\"Dans combien de temps ma réclamation sera-t-elle réglée? \")]";
    private static final String LO_TXT_CLAIMING_QUESTIONS_TENTH_QUESTION = "//div[contains(text(),\"À quel moment vais-je recevoir mon numéro de réclamation?\")]";
    private static final String LO_TXT_CLAIMING_QUESTIONS_ELEVENTH_QUESTION = "//div[contains(text(),\"Comment puis-je demander le remboursement de frais de voyage payés au moyen des points récompenses accumulés sur une carte de crédit?\")]";
    private static final String LO_TXT_CLAIMING_QUESTIONS_FIRST_QUESTION_RESPONSE = "//p[contains(text(),\"Veuillez ne pas les payer, à moins que nous vous le demandions. Envoyez-les-nous afin que nous puissions les ajouter à votre réclamation.\")]";
    private static final String LO_TXT_CLAIMING_QUESTIONS_SECOND_QUESTION_RESPONSE = "//p[contains(text(),\"Rendez-vous à la page Centre d’aide et sélectionnez l’option appropriée pour nous joindre.\")]";
    private static final String LO_TXT_CLAIMING_QUESTIONS_THIRD_QUESTION_RESPONSE = "//p[contains(text(),\"Si vous avez des dépenses personnelles liées à votre réclamation, vous pouvez les soumettre pour révision en ligne ou nous les envoyer par la poste avec un formulaire de réclamation.\")]";
    private static final String LO_TXT_CLAIMING_QUESTIONS_FOURTH_QUESTION_RESPONSE = "//p[contains(text(),\"Nous acceptons des copies claires et lisibles. Veuillez conserver les originaux dans vos dossiers, car nous pourrions vous les demander ultérieurement.\")]";
    private static final String LO_TXT_CLAIMING_QUESTIONS_FIFTH_QUESTION_RESPONSE = "//p[contains(text(),\"Nous vous rembourserons les frais admissibles en dollars canadiens. Si vous avez effectué des paiements dans d'autres devises, nous utiliserons le taux de change en vigueur le jour de votre paiement pour déterminer le montant canadien qui vous est dû.\")]";
    private static final String LO_TXT_CLAIMING_QUESTIONS_SIXTH_QUESTION_RESPONSE = "//p[contains(text(),\"Vous trouverez notre adresse postale sur la page Centre d’aide.\")]";
    private static final String LO_TXT_CLAIMING_QUESTIONS_SEVENTH_QUESTION_RESPONSE = "//p[contains(text(),\"Pour soumettre une nouvelle réclamation en ligne, cliquez sur l’option Commencer une nouvelle réclamation.\")]";
    private static final String LO_TXT_CLAIMING_QUESTIONS_EIGHTH_QUESTION_RESPONSE = "//p[contains(text(),\"Pour suivre l’état de votre réclamation, rendez-vous à la section État de la réclamation.\")]";
    private static final String LO_TXT_CLAIMING_QUESTIONS_NINTH_QUESTION_RESPONSE = "//p[contains(text(),\"Nous nous efforçons de régler votre réclamation le plus efficacement possible. Assurez-vous de fournir tous les documents exigés dans les meilleurs délais afin d’accélérer le traitement de votre réclamation. Nous rendons une décision sur la plupart des réclamations dans les 30 jours suivant la réception des documents requis.\")]";
    private static final String LO_TXT_CLAIMING_QUESTIONS_TENTH_QUESTION_RESPONSE = "//p[contains(text(),\"Lorsque vous soumettez les documents requis et confirmez les renseignements de votre réclamation, notamment votre nom, votre date de naissance ainsi que la raison pour laquelle vous soumettez une demande, une réclamation sera créée et vous recevrez votre numéro de réclamation par courriel.\")]";
    private static final String LO_TXT_CLAIMING_QUESTIONS_ELEVENTH_QUESTION_RESPONSE = "//p[contains(text(),\"Vous pouvez demander le remboursement de frais de voyage payés avec des points en indiquant la valeur équivalente en dollars canadiens ou de la devise étrangère applicable dans la section « Dépenses et remboursement » du formulaire de réclamation. Veuillez noter que vous obtiendrez un remboursement de la valeur monétaire des points utilisés.\")]";
    private static final String LO_TXT_CLAIMING_DOCUMENTS = "//strong[contains(text(),'Documents de réclamation')]";
    private static final String LO_TXT_CLAIMING_DOCUMENTS_FIRST_QUESTION = "//div[contains(text(),'Quelle est la différence entre une agence de voyage et un fournisseur de voyage?')]";
    private static final String LO_TXT_CLAIMING_DOCUMENTS_FIRST_QUESTION_RESPONSE = "//p[contains(text(),\"Une agence de voyage organise et aide à planifier les voyages, mais n'offre pas de services de voyage. Les voyageurs peuvent réserver des forfaits de voyage qui comprennent les vols, les transferts, les séjours à l'hôtel, les croisières et les visites guidées, le tout sur une seule facture. L'agence collecte le paiement de tous les arrangements du voyage, qui sont fournis par les différents fournisseurs de voyag\")]";
    private static final String LO_TXT_CLAIMING_DOCUMENTS_SECOND_QUESTION = "//div[contains(text(),\"Pourquoi dois-je fournir une preuve d'annulation du fournisseur de voyage si j'ai déjà annulé mon voyage auprès de l'agence de voyage?\")]";
    private static final String LO_TXT_CLAIMING_DOCUMENTS_SECOND_QUESTION_RESPONSE = "//p[contains(text(),\"Le remboursement couvert par l'assurance dépend des conditions de chacun des fournisseurs de voyage impliqué dans votre voyage. Ces conditions d'annulation peuvent varier de celles de votre agence de v\")]";
    private static final String LO_TXT_CLAIMING_DOCUMENTS_THIRD_QUESTION = "//div[contains(text(),\"Pourquoi ai-je besoin de téléverser le certificat médical de Global Excel au lieu du billet d'un médecin? / Pourquoi dois-je quand même soumettre le certificat médical de Global Excel si j'ai déjà envoyé un billet du médecin?\")]";
    private static final String LO_TXT_CLAIMING_DOCUMENTS_THIRD_QUESTION_RESPONSE = "//p[contains(text(),\"Le certificat médical de Global Excel comprend des champs spécifiques qui doivent être remplis par un médecin afin de faciliter le processus de réclamation. Un billet du médecin ne contient généralement pas tous les renseignements nécessaires, ce qui peut causer des retards.\")]";
    private static final String LO_TXT_CLAIMING_DOCUMENTS_FOURTH_QUESTION = "//div[contains(text(),\"Pourquoi dois-je soumettre un certificat médical de Global Excel provenant de mon médecin de famille si j'en ai déjà envoyé un provenant d'un médecin spécialiste?\")]";
    private static final String LO_TXT_CLAIMING_DOCUMENTS_FOURTH_QUESTION_RESPONSE = "//p[contains(text(),\"Le certificat médical de Global Excel doit avoir été rempli par le premier médecin que vous avez consulté pour le problème de santé faisant l'objet de votre réclamation. La compagnie d'assurance a besoin de tous les renseignements concernant le problème de santé depuis l'apparition des pr\")]";
    private static final String LO_TXT_CLAIMING_DOCUMENTS_FIFTH_QUESTION = "//div[contains(text(),\"Pourquoi ai-je besoin d'envoyer un relevé bancaire ou de carte de crédit?\")]";
    private static final String LO_TXT_CLAIMING_DOCUMENTS_FIFTH_QUESTION_RESPONSE = "//p[contains(text(),\"Les relevés bancaires et de carte de crédit sont nécessaires à la vérification des paiements et des achats associés à votre réclamation.\")]";
    private static final String LO_TXT_CLAIMING_DOCUMENTS_SIXTH_QUESTION = "//div[contains(text(),\"Que dois-je faire si je ne retrouve pas mon devis de réservation originale?\")]";
    private static final String LO_TXT_CLAIMING_DOCUMENTS_SIXTH_QUESTION_RESPONSE = "//p[contains(text(),\"Veuillez contacter l'agence de voyage ou le fournisseur de voyage avec qui vous avez fait votre réservation initiale. Vous pourrez recevoir une copie de votre devis de réservation.\")]";
    private static final String LO_TXT_CLAIMING_DOCUMENTS_SEVENTH_QUESTION = "//div[contains(text(),\"Que dois-je faire si je n'ai pas de preuve d'annulation?\")]";
    private static final String LO_TXT_CLAIMING_DOCUMENTS_SEVENTH_QUESTION_RESPONSE = "//p[contains(text(),\"Veuillez contacter l'agence de voyage ou le fournisseur de voyage avec qui vous avez fait votre réservation initiale. Vous pourrez recevoir une copie de votre preuve d'annulation.\")]";
    private static final String LO_TXT_CLAIMING_DOCUMENTS_EIGHTH_QUESTION = "//div[contains(text(),\"Quelle taille et quel format de fichiers puis-je téléverser?\")]";
    private static final String LO_TXT_CLAIMING_DOCUMENTS_EIGHTH_QUESTION_RESPONSE = "//p[contains(text(),\"Les formats de fichiers acceptés sont les suivants : PDF, TIFF, PNG, JPEG, JPG, GIF, BMP, DOC, DOCX, RTF, TXT et ODT.\")]";
    private static final String LO_TXT_CLAIMING_DOCUMENTS_NINTH_QUESTION = "//div[contains(text(),\"Ai-je besoin de soumettre les reçus pour les dépenses engagées?\")]";
    private static final String LO_TXT_CLAIMING_DOCUMENTS_NINTH_QUESTION_RESPONSE = "//p[contains(text(),\"Si vous demandez le remboursement de vos frais personnels, vous devez fournir des reçus indiquant le détail des articles et de leurs coûts pour justifier votre demande. Toutefois, si vous ne demandez pas le remboursement de ces frais, il n'est pas obligatoire de fournir des reçus.\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_SECTION = "//strong[contains(text(),'Soutien technique')]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_FIRST_QUESTION = "//div[contains(text(),\"Comment puis-je retrouver le brouillon de ma réclamation?\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_FIRST_QUESTION_RESPONSE = "//p[contains(text(),\"Pour récupérer le brouillon de votre réclamation, veuillez suivre les étapes suivantes :\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_SECOND_QUESTION = "//div[contains(text(),\"Je n'ai pas reçu le code de vérification. Que dois-je faire pour l'obtenir?\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_SECOND_QUESTION_RESPONSE = "//p[contains(text(),\"Si vous n'avez pas reçu le code de vérification, suivez ces étapes :\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_THIRD_QUESTION = "//div[contains(text(),\"Le code de vérification que j'ai reçu ne fonctionne pas. Que dois-je faire?\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_THIRD_QUESTION_RESPONSE = "//p[contains(text(),\"Le message d'erreur « Le code de vérification est incorrect ou a expiré » s'affiche lorsque le code saisi est incorrect ou n'est plus valide. Pour résoudre ce problème :\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_FOURTH_QUESTION = "//div[contains(text(),\"Que faire si la vérification de mon numéro de téléphone échoue lors de l’enregistrement du brouillon de réclamation?\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_FOURTH_QUESTION_RESPONSE = "//p[contains(text(),\"Si la vérification du numéro de téléphone échoue lors de l’enregistrement du brouillon de la réclamation, suivez ces étapes:\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_FIFTH_QUESTION = "//div[contains(text(),\"Ai-je besoin d'un téléphone cellulaire pour recevoir le code de vérification?\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_FIFTH_QUESTION_RESPONSE = "//p[contains(text(),\"Oui, vous avez besoin d'un téléphone cellulaire pour recevoir le code de vérification. Le code est envoyé par SMS au numéro de téléphone cellulaire que vous avez indiqué dans la section « À propos du demandeur » de votre réclamation. Cela assure la sécurité de votre compte.\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_SIXTH_QUESTION = "//div[contains(text(),\"Que faire si je n'ai plus accès à mon téléphone?\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_SIXTH_QUESTION_RESPONSE = "//p[contains(text(),\"Notre système d'authentification envoie des codes de vérification au numéro de téléphone cellulaire que vous avez fourni dans votre réclamation. Il n'est pas lié à un appareil spécifique, mais à votre numéro de téléphone cellulaire.\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_SEVENTH_QUESTION = "//div[contains(text(),\"À quel numéro de téléphone cellulaire le code de vérification est-il envoyé?\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_SEVENTH_QUESTION_RESPONSE = "//p[contains(text(),\"Le code de vérification à usage unique est envoyé au numéro de téléphone cellulaire que vous avez indiqué dans la section « À propos du demandeur » de votre réclamation.\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_EIGHTH_QUESTION = "//div[contains(text(),\"Combien de temps faut-il pour recevoir le code de vérification?\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_EIGHTH_QUESTION_RESPONSE = "//p[contains(text(),\"Le code de vérification est envoyé immédiatement sur demande. Les délais de réponse peuvent dépendre de votre opérateur de téléphonie cellulaire, de l'état du réseau ou de la disponibilité du service. Si vous ne recevez pas le code dans les 2 minutes, renvoyez-le et réessayez.\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_NINTH_QUESTION = "//div[contains(text(),\"Dois-je saisir un code de vérification chaque fois que j'accède à ma réclamation?\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_NINTH_QUESTION_RESPONSE = "//p[contains(text(),\"Oui, vous devez saisir un code de vérification chaque fois que vous accédez au brouillon de votre réclamation. Le système envoie un nouveau code de vérification au numéro de téléphone cellulaire que vous avez fourni dans la section « À propos du demandeur » de votre réclamation.\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_TENTH_QUESTION = "//div[contains(text(),\"Puis-je recevoir le code de vérification par courriel?\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_TENTH_QUESTION_RESPONSE = "//p[contains(text(),\"Non, nous n'envoyons pas le code de vérification par courriel. Pour des raisons de sécurité, nous ne l'envoyons qu'au numéro de téléphone cellulaire que vous avez indiqué dans la section « À propos du demandeur » du brouillon de votre réclamation. L'utilisation d'un numéro de téléphone cellulaire renforce la sécurité du compte et aide à prévenir les accès non autorisés.\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_ELEVENTH_QUESTION = "//div[contains(text(),\"La réception du code de vérification entraîne-t-elle des frais?\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_ELEVENTH_QUESTION_RESPONSE = "//p[contains(text(),\"Les frais dépendent de votre forfait de téléphonie cellulaire. Les tarifs standards des SMS et des données peuvent s'appliquer, selon les conditions de votre opérateur.\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_TWELFTH_QUESTION = "//div[contains(text(),\"Puis-je utiliser un numéro de téléphone cellulaire international pour m'identifier?\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_TWELFTH_QUESTION_RESPONSE = "//p[contains(text(),\"Oui, vous pouvez utiliser un numéro de téléphone international pour l'authentification, mais il doit s'agir du même numéro que celui enregistré au moment de la création de la réclamation.\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_THIRTEENTH_QUESTION = "//div[contains(text(),\"Puis-je répondre au numéro qui envoie le code de vérification?\")]";
    private static final String LO_TXT_TECHNICAL_SUPPORT_THIRTEENTH_QUESTION_RESPONSE = "//p[contains(text(),\"Non, vous ne pouvez pas répondre au numéro qui envoie le code de vérification à usage unique. Ce numéro est utilisé uniquement pour l’envoi des codes d’authentification et n’accepte pas les messages entrants.\")]";


    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Help_Centre(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_HELP_CENTER_PAGE_VERIFY , FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'CONTACT US' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickContactUsButton() {
        String result = clickLocator(LO_BUT_CONTACT_US, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'Manulife' logo.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnManulifeLogoTopLeftCorner() {
        String result = clickLocator(LO_IMG_MANULIFE_LOGO_TOP, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'VIEW' button under Check Claim Status option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnViewUnderCheckClaimStatusOption() {
        String result = clickLocator(LO_BUT_VIEW_CHECK_CLAIM_STATUS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'VIEW' button under the Submit Documents card layout.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnViewUnderSubmitDocumentsOption() {
        String result = clickLocator(LO_BUT_VIEW_SUBMIT_DOCUMENTS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    
     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyContactUsHelpCentreSection() {
        String result = validateLocatorExists(LO_TXT_HOW_CAN_WE_ASSIST_YOU, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Clicks the 'Customer relation' card under the help centre page.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickCustomerRelations() {
        String result = clickLocator(LO_TXT_CUSTOMER_RELATIONS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyCustomerRelationsPage() {
        String result = validateLocatorExists(LO_TXT_CUSTOMER_RELATIONS_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Enters the policy number.
     * 
     * @param policyNumber The policy number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterPolicyNumber(String policyNumber) {
        String result = setText(LO_EDT_POLICY_NUMBER, policyNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the claim number.
     * 
     * @param claimNumber The claim number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterClaimNumber(String claimNumber) {
        String result = setText(LO_EDT_CLAIM_NUMBER, claimNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    
    /**
     * Enters the First Name.
     * 
     * @param firstName The First Name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterFirstName(String firstName) {
        String result = setText(LO_EDT_FIRST_NAME, firstName, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the Last Name.
     * 
     * @param lastName The Last Name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterLastName(String lastName) {
        String result = setText(LO_EDT_LAST_NAME, lastName, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the Date of Birth.
     * 
     * @param datOfBirth The date of birth to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterDOB(String dateOfBirth) {
        String result = setText(LO_EDT_DATE_OF_BIRTH, dateOfBirth, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the Email.
     * 
     * @param email The email to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterEmail(String email) {
        String result = setText(LO_EDT_EMAIL, email, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the Phone Number.
     * 
     * @param phone The phone number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterPhone(String phone) {
        String result = setText(LO_EDT_PHONE_NUMBER, phone, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the text in textarea.
     * 
     * @param text The text to be entered in the textarea.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterText(String text) {
        String result = setText(LO_EDT_TEXT_TEXTAREA, text, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the text in textarea.
     * 
     * @param text The text to be entered in the textarea.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterTextInTextArea(String text) {
        String result = setText(LO_EDT_TEXT_TEXTAREA, text, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verifies if the header "Submit Bills or Documents" exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifySubmitBillsOrDocumentsHeader() {
        String result = validateLocatorExists(LO_TXT_SUBMIT_BILLS_OR_DOCUMENTS_SECTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verifies if the header "Customer Relations" exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyCustomerRelationsHeader() {
        String result = validateLocatorExists(LO_TXT_CUSTOMER_RELATIONS_FORM_SECTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * clicks on the "Click here" link under Submit Bill or Documents.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String clickHereTextLink() {
        String result = clickLocator(LO_LNK_CLICK_HERE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects what you need to submit.
     * 
     * @param whatYouNeedToSubmit what you need to submit is selected from a dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectWhatYouNeedToSubmit(String whatYouNeedToSubmit) {
        String result = setDropdownAppian(LO_LST_WHAT_YOU_NEED_TO_SUBMIT, whatYouNeedToSubmit, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects the claim type from a dropdown.
     * 
     * @param claimType what you need to submit is selected from a dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectClaimType(String claimType) {
        String result = setDropdownAppian(LO_LST_CLAIM_TYPE, claimType, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects the document type from a dropdown.
     * 
     * @param documentType the type of document is selected from a dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectDocumentType(String documentType) {
        waitForDuration(15, documentType, false);
        String result = setDropdownAppian(LO_LST_DOCUMENT_TYPE, documentType, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Selects the document type from a dropdown.
     * 
     * @param documentType the type of document is selected from a dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectDocumentType2(String documentType) {
        String result = setDropdownAppian(LO_LST_DOCUMENT_TYPE, documentType, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the first Document.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadDocumentType1(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_DOCUMENT_TYPE1);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the second Document.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadDocumentType2(String filePath) {
        waitForDuration(15, "s", false); // Wait to perform next check
        String result = uploadFileV2(filePath, LO_DOC_DOCUMENT_TYPE2);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * clicks on Add another Document.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public String clickOnAddAnotherDocument() {
        String result = clickLocator(LO_BUT_ADD_ANOTHER_DOCUMENT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'Claim Status' card.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickClaimStatusCard() {
        String result = clickLocator(LO_TXT_CLAIM_STATUS_CARD, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Clicks the "View your Claim Status" Link highlighted in red
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnViewYourClaimStatusLink() {
        String result = clickLocator(LO_LNK_VIEW_YOUR_CLAIM_STATUS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Claim Status section is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyClaimStatusSection() {
        String result = validateLocatorExists(LO_TXT_CLAIM_STATUS_SECTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * clicks on the "Submit Bill or Documents" card.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

     public String clickSubmitBillOrDocumentCard() {
        String result = clickLocator(LO_TXT_SUBMIT_BILLS_OR_DOCUMENTS_CARD, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Validates if Emergency Assistance section displays two TD phone numbers by default
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String VerifyEmergencyAssistanceSectionDisplaysTwoPhoneNumbers(String expectedFirstNumber, String expectedSecondNumber) {
        String result = validateWithinLocatorText(LO_TXT_VALID_EMARGENCY_ASSISTANCE, expectedFirstNumber, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }  
     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String VerifyEmergencyNumber() {
        String result = validateLocatorExists(LO_TXT_VALID_EMERGENCY_ASSISTANCE_NUMBER , FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }   
     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String VerifyMgbEmergencyNumber() {
        String result = validateLocatorExists(LO_TXT_VALID_MGB_EMERGENCY_ASSISTANCE_NUMBER , FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }   

/**
 * Clicks the 'General Question' card under the help centre page.
 * 
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public String clickGeneralQuestion() {
    String result = clickLocator(LO_BUT_GENERAL_QUESTION, FW_ConfigMgr.getDefaultTimeout());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;

}
/**
 * Validates if current webpage is loaded and correct.
 *
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public String verifyGeneralQuestionsPage() {
    String result = validateLocatorExists(LO_TXT_GENERAL_QUESTIONS_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

/**
 * Scrolls down on the page.
 * 
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public String scrollDown() {
    String result = scrollToLocator(LO_TXT_FQA);
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

/**
 * Clicks the 'Second Frequently Asked Question'
 * 
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public String clickOnFirstFAQ() {
    String result = clickLocator(LO_TXT_FQA, FW_ConfigMgr.getDefaultTimeout());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

/**
 * Validates if the response displayed correctly.
 *
 * @return A string including [PASS] or [FAIL] along with specific result
 *         details.
 */
public String validateFirstQuestionResponse() {
    String result = validateLocatorExists(LO_TXT_FIRST_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
            FW_ConfigMgr.getDefaultInterval());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

/**
 * Clicks the 'View All FAQs'link.
 * 
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public String clickOnViewAllFAQs() {
    String result = clickLocator(LO_LINK_VIEW_ALL_FAQs, FW_ConfigMgr.getDefaultTimeout());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

/**
 * Validates if the Travel and Assistance questions displayed correctly.
 *
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public String validateTravelAndAssistanceQuestions() {
    String result = validateLocatorExists(LO_TXT_TRAVEL_AND_ASSISTANCE, FW_ConfigMgr.getDefaultTimeout(),
            FW_ConfigMgr.getDefaultInterval());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

/**
 * Validates if the claiming questions displayed correctly.
 *
 * @return A string including [PASS] or [FAIL] along with specific result
 *         details.
 */
public String validateClaimingQuestions() {
    String result = validateLocatorExists(LO_TXT_CLAIMING, FW_ConfigMgr.getDefaultTimeout(),
            FW_ConfigMgr.getDefaultInterval());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

/**
 * Clicks the "Claiming Questions" section
 * 
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public String clickOnClaimingQuestionsSection() {
    String result = clickLocator(LO_TXT_CLAIMING, FW_ConfigMgr.getDefaultTimeout());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

/**
 * Clicks the 'Emergency Travel Assistance' card.
 * 
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public String clickEmergencyTravelAssistance() {
    String result = clickLocator(LO_SLCT_EMERGENCY_TRAVEL_ASSISTANCE, FW_ConfigMgr.getDefaultTimeout());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

/**
 * Validates if the Emergency Travel Assistance section displayed correctly.
 *
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public String validateEmergencyTravelAssistance() {
    String result = validateLocatorExists(LO_TXT_EMERGENCY_TRAVEL_ASSISTANCE, FW_ConfigMgr.getDefaultTimeout(),
            FW_ConfigMgr.getDefaultInterval());
    return result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
}

/**
 * Enters the Alternate Phone Number.
 * 
 * @param alternatePhone The alternate phone number to be entered.
 * 
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public String enterAlternatePhoneNumber(String alternatePhone) {
    String result = setText(LO_EDT_ALTERNATE_PHONE_NUMBER, alternatePhone, FW_ConfigMgr.getDefaultTimeout(), false);
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}
/**
 * Validates if the Consumer or Small Business Number displayed correctly.
 *
 * @return A string including [PASS] or [FAIL] along with specific result
 *         details.
 */
public String validateConsumerorSmallBusinessNumber() {
    String result = validateLocatorExists(LO_TXT_VALID_CONSUMER_NUMBER, FW_ConfigMgr.getDefaultTimeout(),
            FW_ConfigMgr.getDefaultInterval());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

    /**
     * Validates if the Commercial or Scotia Visa Business Cards Number displayed correctly.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateCommercialNumber() {
        String result = validateLocatorExists(LO_TXT_VALID_COMERCIAL_NUMBER, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects radio button "No" for the dropdown for the question : Is this related to a claim decision letter you received? .
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectNoToRelatedToClaimDecisionLetter() {
        String result = clickLocator(LO_RAD_RELATED_TO_CLAIM_DECISION_LETTER_NO, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects a value from the dropdown of field To help us better understand your situation, please select the topic that best applies to your request.
     * @param topic The topic that best applies to your request.
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectTopicThatAppliesToRequest(String topic) {
        String result = setDropdownAppian(LO_LST_SELECT_TOPIC, topic, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads a document.
     * 
     * @param filePath The relative path of the payment proof file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadDocument(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_UPLOAD);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGem_Top_Left_Logo_MGB() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_MGB, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Validates if the Help Centre at top right is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateHelpCentreHeader() {
        String result = validateLocatorExists(LO_LNK_HELP_CENTRE_TOP, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the French/English Button toggle at top right is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFrenchButtonToggle() {
        String result = validateLocatorExists(LO_BUT_FRANÇAIS, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressHeader() {
        String result = validateLocatorExists(LO_TXT_MAILING_ADDRESS_HEADING, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the Sub-Title 1 for Mailing Address heading at bottom towards footer of page is present(Manulife).
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressSubHeadingTitleLeft_Manulife(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_HEADING_SUB_LEFT_MANULIFE,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Validates if the Sub-Title 2 for Mailing Address heading at bottom towards footer of page is present(Manulife).
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressSubHeadingTitleLeft_Manulife2(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Validates if the PO.BOX for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressPOBOXLeft(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the PO.BOX for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressPOBOXStationLeft(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the City for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressCityLeft(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Validates if the Province for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressProvinceLeft(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the Country for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressCountryLeft(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Validates if the Country for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressPostalCodeLeft(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Validates if the Sub-Title 1 for Mailing Address heading at bottom towards footer of page is present(Manulife).
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressSubHeadingTitleRight_Manulife(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_HEADING_SUB_RIGHT_MANULIFE,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the Sub-Title 2 for Mailing Address heading at bottom towards footer of page is present(Manulife).
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressSubHeadingTitleRight_Manulife2(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Validates if the Street for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressPOBOXRight(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the Building for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressBuildingRight(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Validates if the Province for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressStateRight(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the Province for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressProvinceRight(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Validates if the Country for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressZipCodeRight(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Send us a message includes a Contact Us card with a button at the bottom.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     * 
     */
    public String verifySendUsMessageContainsContactUsCart(String button) {
        String result = validateWithinLocatorText(LO_TXT_VERIFY_SEND_US_MESSAGE_CONTAINS_CONTACT_US, button, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Check Claim Status card has a button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyCheckClaimStatusCardContainsButton(String button) {
        String result = validateWithinLocatorText(LO_TXT_VERIFY_CHECK_CLAIM_STATUS_CARD, button, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     *Test to chech if "Check Claim Status's button is functional.
    * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickCheckClaimStatusButton() {
        String result = clickLocator(LO_BUT_CHECK_CLAIM_STATUS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Submit Documents" card with a button at the bottom is available.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifySubmitDocumentsCardContainsButton(String button) {
        String result = validateWithinLocatorText(LO_TXT_VERIFY_SUBMIT_DOCUMENTS_CARD, button, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Test to check if "Submit Documents" button is functional.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickSubmitDocumentsButton() {
        String result = clickLocator(LO_BUT_SUBMIT_DOCUMENTS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks "BACK" button on the page.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickBackButton() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;      
    }

    /**
     * Validates if the "FAQ" section displays three common questions.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyFAQSectionDisplaysThreeCommonQuestions(String expectedFirstQuestion, String expectedSecondQuestion, String expectedThirdQuestion) {
        String result = validateLocatorExists(LO_TXT_VERIFY_FAQ_SECTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result += validateWithinLocatorText(LO_TXT_VERIFY_FAQ_SECTION, expectedFirstQuestion, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result += validateWithinLocatorText(LO_TXT_VERIFY_FAQ_SECTION, expectedSecondQuestion, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result += validateWithinLocatorText(LO_TXT_VERIFY_FAQ_SECTION, expectedThirdQuestion, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "VIEW ALL FAQS" button to access all FAQs is under the "FAQ" section.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyViewAllFAQsButton(String buttonText) {
        String result = validateWithinLocatorText(LO_TXT_VERIFY_FAQ_SECTION, buttonText, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the "VIEW ALL FAQS" button to access all FAQs.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickViewAllFAQsButton() {
        String result = clickLocator(LO_BUT_VIEW_ALL_FAQS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Mailing addresses" information is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyMailingAddressesInformation(String expectedText) {
        String result = validateWithinLocatorText(LO_TXT_VERIFY_MAILING_ADDRESSES, expectedText, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Second Frequently Asked Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnSecondFAQ() {
        String result = clickLocator(LO_TXT_SECOND_FAQ, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Third Frequently Asked Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnThirdFAQ() {
        String result = clickLocator(LO_TXT_THIRD_FAQ, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Second Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateSecondQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_SECOND_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Third Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateThirdQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_THIRD_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Travel and Assistance first question.
     * 
     * 
     */
    public String clickOnTravelAndAssistanceFirstQuestion() {
        String result = clickLocator(LO_TXT_TRAVEL_AND_ASSISTANCE_FIRST_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Travel and Assistance second question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnTravelAndAssistanceSecondQuestion() {
        String result = clickLocator(LO_TXT_TRAVEL_AND_ASSISTANCE_SECOND_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Travel and Assistance third question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnTravelAndAssistanceThirdQuestion() {
        String result = clickLocator(LO_TXT_TRAVEL_AND_ASSISTANCE_THIRD_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;  
    }

    /**
     * Clicks on Travel and Assistance fourth question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnTravelAndAssistanceFourthQuestion() {
        String result = clickLocator(LO_TXT_TRAVEL_AND_ASSISTANCE_FOURTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;  
    }

    /**
     * Clicks on Travel and Assistance fifth question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnTravelAndAssistanceFifthQuestion() {
        String result = clickLocator(LO_TXT_TRAVEL_AND_ASSISTANCE_FIFTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Travel and Assistance first Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateTravelAndAssistanceFirstQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_TRAVEL_AND_ASSISTANCE_FIRST_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Travel and Assistance second Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateTravelAndAssistanceSecondQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_TRAVEL_AND_ASSISTANCE_SECOND_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Travel and Assistance third Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateTravelAndAssistanceThirdQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_TRAVEL_AND_ASSISTANCE_THIRD_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Travel and Assistance fourth Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateTravelAndAssistanceFourthQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_TRAVEL_AND_ASSISTANCE_FOURTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Travel and Assistance fifth Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateTravelAndAssistanceFifthQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_TRAVEL_AND_ASSISTANCE_FIFTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Claiming Questions first question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnClaimingQuestionsFirstQuestion() {
        String result = clickLocator(LO_TXT_CLAIMING_QUESTIONS_FIRST_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Claiming Questions first Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimingQuestionsFirstQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_CLAIMING_QUESTIONS_FIRST_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Claiming Questions second question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnClaimingQuestionsSecondQuestion() {
        String result = clickLocator(LO_TXT_CLAIMING_QUESTIONS_SECOND_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;  
    }

    /**
     * Validates if the response for Claiming Questions second Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimingQuestionsSecondQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_CLAIMING_QUESTIONS_SECOND_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Claiming Questions third question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnClaimingQuestionsThirdQuestion() {
        String result = clickLocator(LO_TXT_CLAIMING_QUESTIONS_THIRD_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Claiming Questions third Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimingQuestionsThirdQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_CLAIMING_QUESTIONS_THIRD_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval()); 
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
    * Clicks on Claiming Questions fourth question.
    * 
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
   public String clickOnClaimingQuestionsFourthQuestion() {
       String result = clickLocator(LO_TXT_CLAIMING_QUESTIONS_FOURTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
       result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
       return result;
   }

    /**
     * Validates if the response for Claiming Questions fourth Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimingQuestionsFourthQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_CLAIMING_QUESTIONS_FOURTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Claiming Questions fifth question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnClaimingQuestionsFifthQuestion() {
        String result = clickLocator(LO_TXT_CLAIMING_QUESTIONS_FIFTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Claiming Questions fifth Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimingQuestionsFifthQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_CLAIMING_QUESTIONS_FIFTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Claiming Questions sixth question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnClaimingQuestionsSixthQuestion() {
        String result = clickLocator(LO_TXT_CLAIMING_QUESTIONS_SIXTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Claiming Questions sixth Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimingQuestionsSixthQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_CLAIMING_QUESTIONS_SIXTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Claiming Questions seventh question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String clickOnClaimingQuestionsSeventhQuestion() {
        String result = clickLocator(LO_TXT_CLAIMING_QUESTIONS_SEVENTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Claiming Questions seventh Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimingQuestionsSeventhQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_CLAIMING_QUESTIONS_SEVENTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Claiming Questions eighth question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnClaimingQuestionsEighthQuestion() {
        String result = clickLocator(LO_TXT_CLAIMING_QUESTIONS_EIGHTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Claiming Questions eighth Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimingQuestionsEighthQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_CLAIMING_QUESTIONS_EIGHTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Claiming Questions ninth question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnClaimingQuestionsNinthQuestion() {
        String result = clickLocator(LO_TXT_CLAIMING_QUESTIONS_NINTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Claiming Questions ninth Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimingQuestionsNinthQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_CLAIMING_QUESTIONS_NINTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Claiming Questions tenth question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnClaimingQuestionsTenthQuestion() {
        String result = clickLocator(LO_TXT_CLAIMING_QUESTIONS_TENTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Claiming Questions tenth Question response is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimingQuestionsTenthQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_CLAIMING_QUESTIONS_TENTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Claiming Questions eleventh question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnClaimingQuestionsEleventhQuestion() {
        String result = clickLocator(LO_TXT_CLAIMING_QUESTIONS_ELEVENTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Claiming Questions eleventh Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimingQuestionsEleventhQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_CLAIMING_QUESTIONS_ELEVENTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Claiming Documents section.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnClaimingDocumentsSection() {
        String result = clickLocator(LO_TXT_CLAIMING_DOCUMENTS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Claiming Documents First Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnClaimingDocumentsFirstQuestion() {
        String result = clickLocator(LO_TXT_CLAIMING_DOCUMENTS_FIRST_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Claiming Documents First Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimingDocumentsFirstQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_CLAIMING_DOCUMENTS_FIRST_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;  
    }

    /**
     * Clicks on Claiming Documents Second Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnClaimingDocumentsSecondQuestion() {
        String result = clickLocator(LO_TXT_CLAIMING_DOCUMENTS_SECOND_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Claiming Documents Second Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimingDocumentsSecondQuestionResponse() {   
        String result = validateLocatorExists(LO_TXT_CLAIMING_DOCUMENTS_SECOND_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Claiming Documents Third Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnClaimingDocumentsThirdQuestion() {
        String result = clickLocator(LO_TXT_CLAIMING_DOCUMENTS_THIRD_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Claiming Documents Third Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimingDocumentsThirdQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_CLAIMING_DOCUMENTS_THIRD_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Claiming Documents Fourth Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
      */
    public String clickOnClaimingDocumentsFourthQuestion() {
        String result = clickLocator(LO_TXT_CLAIMING_DOCUMENTS_FOURTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Claiming Documents Fourth Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimingDocumentsFourthQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_CLAIMING_DOCUMENTS_FOURTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Claiming Documents Fifth Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnClaimingDocumentsFifthQuestion() {
        String result = clickLocator(LO_TXT_CLAIMING_DOCUMENTS_FIFTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Claiming Documents Fifth Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimingDocumentsFifthQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_CLAIMING_DOCUMENTS_FIFTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Claiming Documents Sixth Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnClaimingDocumentsSixthQuestion() {
        String result = clickLocator(LO_TXT_CLAIMING_DOCUMENTS_SIXTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Claiming Documents Sixth Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimingDocumentsSixthQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_CLAIMING_DOCUMENTS_SIXTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Claiming Documents Seventh Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnClaimingDocumentsSeventhQuestion() {
        String result = clickLocator(LO_TXT_CLAIMING_DOCUMENTS_SEVENTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Claiming Documents Seventh Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimingDocumentsSeventhQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_CLAIMING_DOCUMENTS_SEVENTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Claiming Documents Eighth Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnClaimingDocumentsEighthQuestion() {
        String result = clickLocator(LO_TXT_CLAIMING_DOCUMENTS_EIGHTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Claiming Documents Eighth Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimingDocumentsEighthQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_CLAIMING_DOCUMENTS_EIGHTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Claiming Documents Ninth Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnClaimingDocumentsNinthQuestion() {
        String result = clickLocator(LO_TXT_CLAIMING_DOCUMENTS_NINTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Claiming Documents Ninth Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimingDocumentsNinthQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_CLAIMING_DOCUMENTS_NINTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;  
    }

    /**
     * Clicks on Technical Support section.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnTechnicalSupportSection() {
        String result = clickLocator(LO_TXT_TECHNICAL_SUPPORT_SECTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Technical Support First Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnTechnicalSupportFirstQuestion() {
        String result = clickLocator(LO_TXT_TECHNICAL_SUPPORT_FIRST_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Technical Support First Question is displayed correctly.
     * 
     * 
     */
    public String validateTechnicalSupportFirstQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_TECHNICAL_SUPPORT_FIRST_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Technical Support Second Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnTechnicalSupportSecondQuestion() {
        String result = clickLocator(LO_TXT_TECHNICAL_SUPPORT_SECOND_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Technical Support Second Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateTechnicalSupportSecondQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_TECHNICAL_SUPPORT_SECOND_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Technical Support Third Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnTechnicalSupportThirdQuestion() {
        String result = clickLocator(LO_TXT_TECHNICAL_SUPPORT_THIRD_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Technical Support Third Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateTechnicalSupportThirdQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_TECHNICAL_SUPPORT_THIRD_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Technical Support Fourth Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnTechnicalSupportFourthQuestion() {
        String result = clickLocator(LO_TXT_TECHNICAL_SUPPORT_FOURTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Technical Support Fourth Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateTechnicalSupportFourthQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_TECHNICAL_SUPPORT_FOURTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Technical Support Fifth Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnTechnicalSupportFifthQuestion() {
        String result = clickLocator(LO_TXT_TECHNICAL_SUPPORT_FIFTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Technical Support Fifth Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateTechnicalSupportFifthQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_TECHNICAL_SUPPORT_FIFTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Technical Support Sixth Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnTechnicalSupportSixthQuestion() {
        String result = clickLocator(LO_TXT_TECHNICAL_SUPPORT_SIXTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;  
    }

    /**
     * Validates if the response for Technical Support Sixth Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateTechnicalSupportSixthQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_TECHNICAL_SUPPORT_SIXTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Technical Support Seventh Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnTechnicalSupportSeventhQuestion() {
        String result = clickLocator(LO_TXT_TECHNICAL_SUPPORT_SEVENTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Technical Support Seventh Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateTechnicalSupportSeventhQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_TECHNICAL_SUPPORT_SEVENTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Technical Support Eighth Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnTechnicalSupportEighthQuestion() {
        String result = clickLocator(LO_TXT_TECHNICAL_SUPPORT_EIGHTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates the response for Technical Support Eighth question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateTechnicalSupportEighthQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_TECHNICAL_SUPPORT_EIGHTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Technical Support Ninth Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnTechnicalSupportNinthQuestion() {
        String result = clickLocator(LO_TXT_TECHNICAL_SUPPORT_NINTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Technical Support Ninth Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateTechnicalSupportNinthQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_TECHNICAL_SUPPORT_NINTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Technical Support Tenth Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnTechnicalSupportTenthQuestion() {
        String result = clickLocator(LO_TXT_TECHNICAL_SUPPORT_TENTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Technical Support Tenth Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateTechnicalSupportTenthQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_TECHNICAL_SUPPORT_TENTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Technical Support Eleventh Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnTechnicalSupportEleventhQuestion() {
        String result = clickLocator(LO_TXT_TECHNICAL_SUPPORT_ELEVENTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;  
    }

    /**
     * Validates if the response for Technical Support Eleventh Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateTechnicalSupportEleventhQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_TECHNICAL_SUPPORT_ELEVENTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Technical Support Twelfth Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnTechnicalSupportTwelfthQuestion() {
        String result = clickLocator(LO_TXT_TECHNICAL_SUPPORT_TWELFTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;  
    }

    /**
     * Validates if the response for Technical Support Twelfth Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateTechnicalSupportTwelfthQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_TECHNICAL_SUPPORT_TWELFTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on Technical Support Thirteenth Question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnTechnicalSupportThirteenthQuestion() {
        String result = clickLocator(LO_TXT_TECHNICAL_SUPPORT_THIRTEENTH_QUESTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the response for Technical Support Thirteenth Question is displayed correctly.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateTechnicalSupportThirteenthQuestionResponse() {
        String result = validateLocatorExists(LO_TXT_TECHNICAL_SUPPORT_THIRTEENTH_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
}