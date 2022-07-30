# filrouge

filrouge en equipe  de la POEC java (ete 2022)

Un organisme de formation, IT-Training, souhaite refaire entièrement son système d’information ainsi que son portail

web. A cet effet, IT-Training a établi une version préliminaire du cahier des charges (CDC). Il est important de noter

que ce dernier pourra tout à fait être modifié et étendu tout le long du cycle de développement et de livraison du SI

ainsi que du portail web. Le délai fixé par le client est de quatre mois maximum à partir de la soumission du CDC.

Le système d’information est assez complexe et est principalement axé sur les points suivants :




1. Le catalogue de formation : Le client souhaite fournir à travers son portail web un accès

à son catalogue, riche de plus 800 formations. Celles-ci couvrent plusieurs domaines, i.e., ressources

humaines, management, finance, informatique, etc. Dans ce qui suit, nous nous intéressons qu’aux formations

liées au domaine de l’informatique.

Les formations sont regroupées par thèmes, i.e., Réseaux, Systèmes d’exploitation, Gestion

de projets, Langages de développement, etc. Chaque thème est ou peut être divisé en sous-thèmes (par

exemple. le thème Langages de développement est composé de JAVA, C#, C++, Langages du WEB, etc.).

Finalement, chaque sous-thème est lui aussi décomposé en d’autres sous-thèmes ou bien directement d’une

liste des formations de ce thème. Exemple, le sous-thème Langages du WEB comprend la liste des formations

sur PHP, JavaScript, Ajax, etc. Bien sûr, une formation peut faire partie de plusieurs sous-thèmes en même

temps. Exemple XML peut faire partie du thème Langages du Web et même temps de celui de Modélisation des

données.




Une fois que le client clique sur la formation PHP par exemple, il pourra accéder au contenu

de la formation ainsi qu’aux informations sur le prix, dates et lieux des prochaines sessions planifiées, et un

lien qui lui permet de tester ses prérequis en ligne pour voir s’il a le niveau nécessaire pour suivre la

formation (i.e., pas trop faible, pas trop fort !). Concernant

les informations sur le contenu de la formation ainsi que sur les détails de présentation, il faudra contacter le

Responsable Catalogue afin de voir avoir lui le contenu à mettre absolument

sur le site ainsi que les données qu’il faudra surlignées et mettre en évidence pour les clients.

Un lien devra bien sûr être fourni au client afin de lui permettre de contacter directement

le service commercial ou bien de s’enregistrer directement en ligne pour suivre une session donnée. Le point

suivant détail cet aspect-là du SI.




2. Enregistrement en ligne pour suivre une session de formation : Si un client est intéressé

par une formation, il doit avoir la possibilité de s’inscrire en ligne en choisissant la date et le lieu de la session

puis en indiquant ces coordonnées ainsi que celle de son entreprise (s’il en fait partie d’une). Bien sûr, l’idéal

est qu’il est fait le test des prérequis (lien sur la page de formation) avant de s’inscrire. Il est aussi possible de

demander ce qu’on appelle une session intra-entreprise. Celle-ci peut se faire selon les dates du client et dans

son entreprise ou bien dans une salle louée par IT-Training. Le client peut également demander une formation

personnalisée selon ces besoins et ces objectifs. Il faudra alors monter un plan de formation et le lui envoyer

pour validation. Pour plus d’information sur ce point n’hésitez pas à contacter le Responsable

d’enregistrement des formations. Une fois une demande de formation effectuée par un client, toute une

logistique se met en place afin d’automatiser et d’accélérer au maximum la mise

en place de la formation ainsi que de son suivi. Le point suivant détail cet aspect.




3. Logistique pour l’organisation de la formation : Il y’a deux types de formations.

Les inter-entreprises et les intra-entreprise. Pour les inters, les sessions sont fixes et organisées selon un

calendrier défini tout le long de l’année. Exemple, pour Java, il y’a systématiquement une session de

programmée par mois et pas centre de formation. Pour XML, vous avez une session tous les deux mois, etc.

On peut s’y inscrire directement en ligne ou bien en prenant contact par mail ou par tél avec le service

commercial d’IT-Training.

Pour les inters, on ne peut pas lancer la formation si le nombre de participants est inférieur

à trois, voire quatre selon le sujet/tarif. Donc, 15 jours avant la formation, si le nombre minimum d’inscrits

n’est pas atteint, il faudra lancer la procédure d’annulation : prévenir le formateur,

les stagiaires, annuler la réservation des salles, le service planning, etc.

Pour les inters, chaque session doit avoir son formateur de planifié au moins 3 mois à l’avance.

Le service logistique contacte le formateur (en consultant sa base de CVs) pour lui proposer

la formation. On commence toujours par le formateur qui a le plus d’expérience dans le sujet mais en plus, par

celui qui a été le mieux noté par les stagiaires lors des précédentes sessions.

En effet IT-Training classe ces formateurs par moyenne selon les évaluations des stagiaires / sessions. Si c’est

la toute première intervention de ce formateur, il faudra alors prévoir une séance de validation technique et

pédagogique du formateur, au moins trois semaines à l’avance.

Les formateurs doivent confirmer au plus vite, sinon, on passe aux suivants. Il arrive aussi

que le formateur se désiste d’une formation cependant, il n’a pas le droit de le faire à moins

de 15 jours de la formation, autrement il risque d’avoir un blâme. Même chose, si IT-Training annule à moins

d’une semaine, elle doit lui régler son intervention ou bien une partie.

Même chose, si un des participants annule 15 jours avant la formation, il doit quand même

la régler.

Dès que le nombre minimum de participants est atteint, toute une logistique se met en place :

- La salle est réservée,

- Les machines installées à distances (images virtuelles) avec les bonnes versions,

et logiciels requis pour la formation,

- Le formateur est averti par mail et doit confirmer,

- Les supports de cours/TP sont imprimés, CDs gravés,

- Les convocations sont envoyées aux stagiaires par courrier et par mail,

- Le planning est mis à jour,

- Les listes de présences sont imprimées,

- Les tickets repas sont imprimés,

- Les formulaires HTML d’évaluation en ligne de la session sont générés et prêts à être utilisés.

Ces derniers sont nominatifs.




Pour plus de détails sur cette partie, merci de contacter le responsable logistique, le responsable installation des

salles, et le responsable planning des intervenants externes.




4. Évaluation de la session : à la fin de chaque session les stagiaires doivent donner leurs appréciations sur le

déroulement de la formation. Celles-ci concernent tous les détails surs :

- La qualité de l’accueil chez IT-Training

- La qualité de l’environnement, i.e., salles, machines, repas, etc.

- Et surtout, très important, la qualité du stage. Cela passe par une évaluation détaillée du Contenu du stage et du

formateur. Une note est donnée (de 1 à 5, 1 étant médiocre, 5 excellent) pour le contenu de la formation, jour par

jour. Ensuite le formateur est évalué sur cinq points : Pédagogie, Maîtrise du domaine, Disponibilité, Réponses aux

questions, et Technique d’animations. Finalement, les stagiaires doivent répondre aux questions suivantes : le

niveau de satisfaction (d’insatisfait à très satisfait), s’ils recommandent ou pas cette formation et s’ils ont

d’autres projets de formations (ce dernier point servira au service commercial afin de proposer à nouveau les

services de IT-Training au client sur les formations souhaitées. Voir point suivant).

L’évaluation doit absolument se faire avant 14h30 le dernier jour de formation. Ceci afin de permettre aux

responsables des formations (inter ou intra si celles-ci se passent dans les locaux d’ITT) de réagir immédiatement en

cas de mauvaises notes et surtout de descendre voir les stagiaires insatisfaits avant leur départ.

Une note inférieure à 3 sur les points cités plus haut déclenche de suite une alerte qualité dans

e tableau de bord du responsable formation qui doit connaitre la source du problème au plus vite.

Si plusieurs stagiaires sont unanimes sur une mauvaise note, la pédagogie du formateur par exemple, ce dernier sera

exclu de la base des formateurs. La seule protection du formateur reste son rôle

et sa capacité à détecter immédiatement le premier jour, pendant le tour de table les personnes qui n’ont pas les

prérequis pour suivre la formation et de les déclarer à ITT. Si les mauvaises notes proviennent

de ces stagiaires alors le formateur est déchargé de toute responsabilité et c’est le commercial qui sera mis en cause

car il n’a pas été bien clair auprès du client. Si c’est le client qui a menti ou mal évalué les prérequis de ses employés,

la responsabilité lui revient. Pour plus de détails sur ce point veuillez contacter le responsable des formations

inter-entreprises.




5. Service de monitoring : c’est ce qui permet aux responsables de voir sur un tableau de bord

toute la logistique d’une formation, du début (demande du client) à sa fin (recueil des appréciations des

stagiaires). Le responsable logistique pourra à tout instant voir par exemple

sur un simple écran l’état d’avancement de la formation Java qui aura lieu la semaine prochaine (i.e., salle

installée, formateur confirmé, support imprimé, etc.) Il pourra alors réagir tout de suite

si jamais un des points de la logistique n’est pas atteint. Même chose pour le responsable

des formations inter. Dans son tableau de bord, il a l’information des absents sur formation,

sa date de fin, et surtout, les évaluations des stagiaires en instantané pour leur dernier jour

de formation. Des alertes seront déclenchées selon leur niveau de gravité. Pour plus de détail

sur ce point, prendre RDV avec le Responsable Logistique et le Responsable de formation Inter-E.




6. Service commerciale et SAV : ce service a pour objectif de prospecter de nouveaux clients,

de relancer les clients ayant émis des souhaits de projets de formations dans les formulaires d’évaluation, de répondre

aux questions des stagiaires avant et après la formation, de prendre

contact avec les clients pour la mise en place d’une formation intra, etc.

C’est aussi ici qu’on aura tous les indicateurs/stats sur le nombre de clients, du chiffre d’affaires,

du nombre de formations données cette année, etc.

Pour plus d’information, veuillez contacter le Responsable Commercial.

