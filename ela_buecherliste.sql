-- ========================================
-- SQL Import für Library Management System
-- ========================================

USE library_management;

-- Alle Bücher einfügen
INSERT INTO books (isbn, title, author, publisher, publication_year, category) VALUES

-- Alfred Adler Werke
('978-3-866471962', 'Der Sinn des Lebens', 'Alfred Adler', 'Fischer & Gann', 2013, 'Psychologie'),
('978-3-866471955', 'Menschenkenntnis', 'Alfred Adler', 'Fischer & Gann', 2007, 'Psychologie'),
('978-3-866478282', 'Praxis und Theorie der Individualpsychologie', 'Alfred Adler', 'Fischer & Gann', 2012, 'Psychologie'),
('978-3730608418', 'Gesammelte Werke', 'Alfred Adler', 'Fischer & Gann', 2018, 'Psychologie'),
('978-3642503832', 'Wörterbuch der Individualpsychologie', 'Alfred Adler', 'Springer', 1982, 'Psychologie'),

-- Erich Fromm Werke
('978-3-423349772', 'Jenseits der Illusion', 'Erich Fromm', 'dtv', 2010, 'Philosophie'),
('978-3-423348805', 'Die Seele des Menschen', 'Erich Fromm', 'dtv', 2010, 'Psychologie'),
('978-3-423349284', 'Die Menschen verstehen', 'Erich Fromm', 'dtv', 2010, 'Psychologie'),
('978-3-423350242', 'Die Furcht vor der Freiheit', 'Erich Fromm', 'dtv', 2010, 'Philosophie'),
('978-3-548377513', 'Die Kunst zu Lieben', 'Erich Fromm', 'Ullstein', 2011, 'Ratgeber'),
('978-3-548367781', 'Die Pathologie der Normalität', 'Erich Fromm', 'Ullstein', 2005, 'Psychologie'),
('978-3-423340076', 'Wege aus einer kranken Gesellschaft', 'Erich Fromm', 'dtv', 2005, 'Soziologie'),
('978-3-499170522', 'Anatomie der menschlichen Destruktivität', 'Erich Fromm', 'Rowohlt', 2015, 'Psychologie'),

-- Spiritualität & Achtsamkeit
('978-3-866474659', 'Tao Te King', 'Laotse', 'Fischer & Gann', 2009, 'Philosophie'),
('978-3-89845-550-3', 'Das Tao der Selbstfindung', 'Theo Fischer', 'Kamphausen', 2004, 'Spiritualität'),
('978-3-89845-046-1', 'Tendenz des Wachstums', 'Theo Fischer', 'Kamphausen', 1998, 'Spiritualität'),
('978-3-89845-4', 'Jenseits des Ego', 'Robert Linssen', 'Kamphausen', 2001, 'Spiritualität'),
('978-3-426876831', 'Achtsam Sprechen und Zuhören', 'Thich Nhat Hanh', 'Knaur', 2015, 'Achtsamkeit'),
('978-3-442345755', 'Das Wunder des bewussten Atmens', 'Thich Nhat Hanh', 'Goldmann', 2008, 'Achtsamkeit'),
('978-3-442345977', 'Das Wunder der Achtsamkeit', 'Thich Nhat Hanh', 'Goldmann', 2009, 'Achtsamkeit'),
('978-3-867283267', 'Achtsamkeit', 'Joseph Goldstein', 'Arbor', 2013, 'Achtsamkeit'),
('978-3-924195465', 'Vipassana Meditation', 'Joseph Goldstein', 'Jhana', 1994, 'Meditation'),
('978-3867814409', 'Die heilende Kraft der Achtsamkeit', 'Jon Kabat-Zinn', 'Arbor', 2013, 'Achtsamkeit'),
('9783641038922', 'Stressbewältigung mit Achtsamkeit', 'Linda Lehrhaupt, Peter Meibert', 'Kösel', 2010, 'Achtsamkeit'),
('978-3-7495-0195-3', 'Achtsamkeit in der Natur', 'Michael Huppertz', 'Junfermann', 2021, 'Achtsamkeit'),
('978-3-608-42927-5', 'Geistestraining - Methoden einer achtsamen Bewusstseinskultur', 'U. Anders-Reuster', 'Klett-Cotta', 2011, 'Achtsamkeit'),

-- Depression & psychische Gesundheit
('978-3-596703609', 'Saturns Schatten: Die dunkle Welt der Depression', 'Andrew Solomon', 'Fischer', 2015, 'Psychologie'),
('978-3-451033506', 'Das Leiden am sinnlosen Leben', 'Viktor E. Frankl', 'Herder', 2016, 'Psychologie'),
('9780380731763', 'Feeling Good: The New Mood Therapy', 'David Burns', 'Harper', 1999, 'Psychologie'),
('978-3-873876286', 'Feeling Good: Depressionen überwinden', 'David Burns', 'Junfermann', 2006, 'Psychologie'),
('978-3752689884', 'Naturtherapie bei Angst & Depression', 'Eskil Burck', 'Books on Demand', 2021, 'Therapie'),
('978-3-406667619', 'Angst: Wie sie die Seele lähmt', 'Scott Stossel', 'C.H. Beck', 2014, 'Psychologie'),
('978-3-608959901', 'Der freie Fall der Spottdrossel', 'Annie Dillard', 'Klett-Cotta', 2018, 'Belletristik'),

-- Selbstwert & persönliche Entwicklung
('978-3-442177455', 'Sei einzig, nicht artig', 'Martin Wehrle', 'Goldmann', 2016, 'Ratgeber'),
('978-3-442393770', 'Die Netten beißen die Hunde', 'Martin Wehrle', 'Goldmann', 2019, 'Ratgeber'),
('978-3-424632002', 'So stärken Sie Ihr Selbstwertgefühl', 'Stefanie Stahl', 'Gräfe und Unzer', 2015, 'Ratgeber'),
('978-3-424632026', 'JA-Nein', 'Stefanie Stahl', 'Gräfe und Unzer', 2017, 'Ratgeber'),
('978-3-424632019', 'So bin ich eben', 'Stefanie Stahl', 'Gräfe und Unzer', 2015, 'Ratgeber'),
('978-3-424631272', 'Das Sonnenkind-Prinzip', 'Julia Tomuschat', 'Gräfe und Unzer', 2019, 'Ratgeber'),
('978-3-492263962', 'Die 6 Säulen des Selbstwertgefühls', 'Nathaniel Branden', 'Piper', 2011, 'Psychologie'),
('978-3-843603911', 'Die Kunst, sich wertzuschätzen', 'Heinz-Peter Röhr', 'Patmos', 2013, 'Ratgeber'),
('978-3-596222025', 'Mars', 'Fritz Zorn', 'Fischer', 2013, 'Biografie'),

-- Kommunikation & Beziehungen
('9783869804682', 'Die neue gewaltfreie Kommunikation', 'Markus Fischer', 'Junfermann', 2020, 'Kommunikation'),
('9798619431551', 'Gewaltfreie Kommunikation', 'Robert Brand', 'Independently Published', 2020, 'Kommunikation'),
('978-3-873870185', 'Kommunikation. Selbstwert. Kongruenz', 'Virginia Satir', 'Junfermann', 2004, 'Psychologie'),
('978-3-99060-182-2', 'Kampfrhetorik', 'Thomas W. Albrecht', 'Goldegg', 2018, 'Kommunikation'),
('978-3-902625793', 'Soviel Liebe wie du brauchst', 'Harville Hendrix', 'Goldmann', 2012, 'Beziehungen'),
('978-3-426787441', 'Ich und die anderen', 'Jens Corssen', 'Knaur', 2009, 'Ratgeber'),

-- Natur & Naturtherapie
('978-3-548-37659-2', 'Der Biophilia-Effekt', 'Clemens G. Arvay', 'Ullstein', 2016, 'Naturwissenschaft'),
('978-3-426658369', 'Im Wald baden', 'Annette Bernjus, Jörg Meier', 'Knaur', 2018, 'Natur'),
('9783426658062', 'Fasten Wandern', 'Rüdiger Dahlke', 'Knaur', 2018, 'Gesundheit'),
('978-3-867810753', 'Die Weisheit der Wildnis', 'Mark Coleman', 'Arbor', 2018, 'Natur'),
('978-3-89060-654-5', 'Spirituelle Ökologie', 'Llewellyn Vaughan-Lee', 'Chalice', 2013, 'Ökologie'),
('978-3-751802222', 'Einen Stein zum Sprechen bringen', 'Annie Dillard', 'Matthes & Seitz', 2020, 'Natur'),
('978-3-87387-699-6', 'Geliebte Erde, gereiftes Selbst', 'Joanna Macy', 'Junfermann', 2010, 'Ökologie'),
('978-9717-5250-50', 'Walden', 'Henry David Thoreau', 'Princeton University Press', 2004, 'Philosophie'),
('978-3-95728-517-1', 'Draußen - Zurück zur Natur', 'Ruth Allen', 'Mosaik', 2020, 'Natur'),
('978-3-88221-657-8', 'Lektionen der Wildnis', 'Gary Snyder', 'Matthes & Seitz', 2009, 'Natur'),
('978-3-89060-632-3', 'Der Geist der Bäume', 'Fred Hageneder', 'Neue Erde', 2000, 'Natur'),
('978-78888767377', 'Nature Speak', 'Ted Andrews', 'Dragonhawk Publishing', 2004, 'Natur'),
('978-3-97387-173-1', 'Erleben durch die Sinne', 'Charles V.W. Brooks', 'Junfermann', 1993, 'Körpertherapie'),
('978-3038002932', 'Naturerfahrung mit allen Sinnen', 'Kari Joller', 'AT Verlag', 2011, 'Natur'),
('978-3-927369-45-0', 'Im Bann der sinnlichen Natur', 'David Abram', 'Klein', 1997, 'Naturphilosophie'),
('978-3-8497-0053-9', 'Systemische Naturtherapie', 'Astrid Habiba Kreszmeier', 'Carl-Auer', 2015, 'Therapie'),
('978-3-8666-3046-8', 'Natur und Menschenseele', 'Bill Plotkin', 'Arbor', 2014, 'Naturtherapie'),
('978-3-621+28610-7', 'Naturtherapie', 'Sandra Knümann', 'Beltz', 2019, 'Therapie'),
('978-3658299385', 'Arbeitsraum Natur', 'Carsten Gans', 'Springer', 2020, 'Therapie'),
('978-1897408001', 'Thinking Like a Mountain', 'Pat Fleming', 'Chelsea Green', 2008, 'Ökologie'),
('978-3-446239357', 'Der Mann, der Bäume pflanzte', 'Jean Giono', 'Hanser', 2020, 'Erzählung'),

-- Psychotherapie & Körpertherapie
('9783499605215', 'Focusing', 'Eugene T. Gendlin', 'Rowohlt', 2012, 'Psychotherapie'),
('9783608892499', 'Dein Körper - Dein Traumdeuter', 'Eugene T. Gendlin', 'Klett-Cotta', 2004, 'Psychotherapie'),
('978-3-608-89282-6', 'Beratung in Bewegung', 'J.F. Weber', 'Klett-Cotta', 2009, 'Therapie'),
('978-3-801718046', 'Neuropsychotherapie', 'Klaus Grawe', 'Hogrefe', 2004, 'Psychotherapie'),
('978-3-608978656', 'Die Heiler - Wirkungsweisen psychotherapeutischer Beeinflussung', 'Jerome D. Frank', 'Klett-Cotta', 2002, 'Psychotherapie'),
('978-3-608946376', 'Angstlust und Regression', 'Michael Balint', 'Klett-Cotta', 2014, 'Psychoanalyse'),
('978-3-642494116', 'Der sensitive Beziehungswahn', 'Ernst Kretschmer', 'Springer', 1966, 'Psychiatrie'),
('978-3-6089820770', 'Grundbegriffe der Individualpsychologie', 'Rudolf Dreikurs', 'Klett-Cotta', 2004, 'Psychologie'),

-- Hildegard von Bingen
('978-3-42665673', 'Die Psychotherapie der Hildegard von Bingen', 'Wighard Strehlow', 'Knaur', 2001, 'Naturheilkunde'),

-- Schatten & Persönlichkeit
('978-3-423351188', 'Die Schattenseite der Seele', 'Connie Zweig', 'dtv', 2011, 'Psychologie'),
('978-3-456849263', 'Die dunkle Seite der Seele', 'Robert Simon', 'Huber', 2009, 'Psychologie'),
('978-3-946136132', 'Der Schatten', 'Robert Bly', 'Scorpio', 2017, 'Psychologie'),
('978-3-458-64343-2', 'Der Heros in tausend Gestalten', 'Joseph Campbell', 'Insel', 2011, 'Mythologie'),

-- Ratgeber & Selbsthilfe
('978-3-451-03254-7', 'Eine Reise von 1000 Meilen beginnt mit dem ersten Schritt', 'Luise Reddemann', 'Herder', 2007, 'Ratgeber'),
('978-3-548064604', 'Das Leben wagen', 'Michael A. Singer', 'Ullstein', 2016, 'Spiritualität'),
('978-3-89845-452-0', 'Was uns alle trägt', 'Silke Gramer-Rottler', 'Kamphausen', 2013, 'Spiritualität'),
('978-3-596190560', 'Sorg dich nicht - lebe', 'Dale Carnegie', 'Fischer', 2011, 'Ratgeber'),
('978-3-596030828', 'Einfach glücklich', 'Stefan Klein', 'Fischer', 2010, 'Ratgeber'),
('978-3-86781-350-1', 'Ruhe da oben', 'Andreas Knuf', 'Balance', 2014, 'Ratgeber'),
('978-3-778782965', 'Buddhas Erfolgsformel für ein erfülltes Leben', 'Thomas Hohensee', 'Ansata', 2010, 'Spiritualität'),
('978-3-406750076', 'Die toxische Macht der Narzissten', 'Marie-France Hirigoyen', 'C.H. Beck', 2019, 'Psychologie'),
('978-3-843414876', 'Mit der Kindheit Frieden schließen', 'Ulrike Dahm', 'Patmos', 2018, 'Ratgeber'),
('978-3-86731-091-8', 'Earthing', 'Clinton Ober, Stephen T. Sinatra, Martin Zucker', 'VAK', 2011, 'Gesundheit'),
('978-3-86882-811-5', 'Die subtile Kunst des Daraufscheißens', 'Mark Manson', 'mvg', 2017, 'Ratgeber'),
('978-3-548063980', 'Die drei Fragen des Lebens', 'Don Miguel Ruiz', 'Ullstein', 2010, 'Spiritualität'),
('978-3-442178582', 'Die 1%-Methode', 'James Clear', 'Goldmann', 2020, 'Ratgeber'),
('978-3-527511266', 'Die sieben Wege zur Effektivität', 'Stephen Covey', 'GABAL', 2018, 'Ratgeber'),
('978-3-596178605', 'Der Sinn des Gebens', 'Stefan Klein', 'Fischer', 2011, 'Ratgeber'),
('9783451601279', 'Toxische Familie', 'Thomas Hohensee', 'Herder', 2020, 'Ratgeber'),
('978-3-442-33650-0', 'Lieben was ist', 'Byron Katie', 'Goldmann', 2002, 'Spiritualität'),
('978-3-8434-1521-7', 'Wer ankommen will, muss losgehen', 'Kerstin Peter', 'Patmos', 2019, 'Ratgeber'),
('9783871591693', 'In Abstand zur inneren Wortmaschine', 'Steven C. Hayes, Spencer Smith', 'dgvt-Verlag', 2010, 'Psychotherapie'),
('978-3-466-30985-6', 'Mitfühlend leben', 'Frits Koster', 'Kösel', 2013, 'Spiritualität'),

-- Gesundheit & Heilung
('979-8320574257', 'The Self Heal Bible', 'Mia Williams', 'Independently Published', 2024, 'Gesundheit'),
('978-3-42665889', 'Die Beeren-Apotheke', 'Barbara Simonsohn', 'Knaur', 2019, 'Naturheilkunde'),
('978-3-426675557', 'Bin raus', 'Felix Klemme', 'Knaur', 2019, 'Gesundheit'),
('978-3969051870', 'Five Days Only - Kochbuch zum Scheinfasten', 'Francesca Mangiameli, Barbara Becker', 'ZS', 2021, 'Kochbuch'),
('978-3-466303816', 'Glück auf Rezept', 'Peter D. Kramer', 'Kösel', 1997, 'Psychopharmakologie'),

-- Philosophie & Gesellschaft
('978-3-492317092', 'Elemente und Ursprünge totaler Herrschaft', 'Hannah Arendt', 'Piper', 2011, 'Politische Philosophie'),
('978-3-039730193', 'Das Handwerk des Lebens', 'Cesare Pavese', 'Kampa', 2020, 'Literatur'),
('978-3-570034750', 'Das Zeitalter des Narzissmus', 'Christopher Lasch', 'Pantheon', 2020, 'Soziologie'),
('9781505422382', 'Die Philosophie des Als Ob', 'Hans Vaihinger', 'CreateSpace', 2015, 'Philosophie'),
('9798871308585', 'Die Säulen der emotionalen Intelligenz', 'James J. Cunningham', 'Independently Published', 2023, 'Psychologie'),
('9783792600351', 'Wege zur inneren Freiheit', 'Erik Blumenthal', 'Kohlhammer', 1977, 'Psychologie'),

-- Diverses
('978-3-932708473', 'Mut tut gut', 'Theo Schoenaker', 'Schönbrunn', 2006, 'Ratgeber'),
('978-3-905933024', 'Menschenarten', 'Ian Hacking', 'S. Fischer', 2008, 'Wissenschaftstheorie'),
('978-3-456852270', 'Die Macht der Introvertierten', 'Marti Olsen Laney', 'Huber', 2010, 'Psychologie'),
('978-3-446187450', 'Multiple Persönlichkeiten', 'Ian Hacking', 'Hanser', 1996, 'Psychologie'),
('978-3423205337', 'Ein Jahr am Meer', 'Joan Anderson', 'dtv', 2006, 'Biografie'),
('978-3-608-42927-5', 'Dem Herzen folgen', 'John Welwood', 'Klett-Cotta', 2013, 'Spiritualität'),
('978-3-616-03155-2', 'Überland', 'Raynor Winn', 'Malik', 2019, 'Reisebericht');


SELECT COUNT(*) as 'Anzahl importierter Bücher' FROM books;


-- Wie viele Bücher sind drin?
SELECT COUNT(*) as 'Anzahl Bücher' FROM books;

-- Alle Bücher anzeigen
SELECT * FROM books ORDER BY author, title;

-- Nach Kategorie gruppiert
SELECT category, COUNT(*) as Anzahl 
FROM books 
GROUP BY category 
ORDER BY Anzahl DESC;

-- Deine teuersten Kategorien 
SELECT category, COUNT(*) as 'Anzahl Bücher'
FROM books 
GROUP BY category;