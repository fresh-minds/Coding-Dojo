# Architecture Kata: SiteOS for building conglomerate

## Business Case

A large construction conglomerate wants a platform that creates a real-time digital twin of active construction sites — aggregating drone surveys, BIM model data, worker badge telemetry, crane sensor feeds, and inspection reports.

### Business Objectives
- Reduce on-site safety incidents by 40% within 18 months of deployment.
- Increase equipment utilization from 61% to at least 78% within 24 months.
- Cut daily site management reporting time per manager from 2.5 hours to under 30 minutes.
- Enable cross-site intelligence: detect and share patterns across the site network.
- Provide real-time dashboards to clients and project directors without manual report preparation.


## Users and Scale

- Site managers
- Safety officers
- Project directors
- Subcontractors 
- .. all across 340 active global construction sites, plus executive stakeholders and external clients who need read-only project visibility.

## Core Requirements

- Ingest real-time telemetry from 43,000+ IoT sensors, worker GPS badges, crane telematics, and drone photogrammetry surveys to maintain a continuously-synchronized 3D digital twin of each site — overlaid on the project's BIM model. 
- Detect safety violations (worker in exclusion zone, structural stress thresholds, fall events) and deliver alerts within 10 seconds. 
- Provide an interactive web-based 3D visualization with time-travel replay, and an executive dashboard aggregating KPIs across all sites.

## Additional Context

- Sites have unreliable LTE/satellite connectivity with outages of up to 45 minutes; safety alerting must continue functioning offline and buffer up to 72 hours of telemetry for reconciliation on reconnect. 
- BIM models range from 18–120 GB and are updated several times a week — only deltas are practical to transmit. 
- Peak ingestion load reaches ~2.1 million sensor events per minute. Subcontractor data must be strictly isolated, worker location data is subject to GDPR, and sites in Germany and the UAE require in-country data residency. 
- The system must support onboarding a new site within 48 hours with no manual cloud configuration.